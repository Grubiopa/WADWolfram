package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author TOSHIBA
 */
@Controller
public class UserController {

    @Autowired
    private UserPersonalDataRepository users;
    @Autowired
    private ProjectRepository projects;
    @Autowired
    private DonationsRepository movements;

    private static final String FILES_FOLDER_USERS = "filesUsers";

    @PostConstruct
    public void init() {
        List<String> role = new ArrayList<>();
        role.add("ADMIN");
        users.save(new UserPersonalData("Gabi", "R", "g.ru@yo.com", "gabi0794", "aaaa", "aaaa", "icon.png", role));
        users.save(new UserPersonalData("TU", "t", "t.ru@yo.com", "tu", "bbbb", "bbbb", "icon.png", role));
        Date d = new Date();
        UserPersonalData u = users.findOne((long) 1);
        Project p = projects.findOne((long) 1);
        movements.save(new Donation(u, p, 50, d));
        movements.save(new Donation(u, p, 60, d));
        movements.save(new Donation(u, p, 40, d));
        p.setParcialBudget(p.getParcialBudget() + 150);
        projects.save(p);
        p = projects.findOne((long) 2);
        movements.save(new Donation(u, p, 10, d));
        p.setParcialBudget(p.getParcialBudget() + 10);
        projects.save(p);
    }

    @RequestMapping(value = "/users/update/{id}", method = RequestMethod.POST)
    public String updateDB(Model m, HttpSession sesion, @RequestParam MultipartFile imagen, @RequestParam String email, @RequestParam String username,
            @RequestParam String oldPassword, @RequestParam String newPassword,/*@RequestParam String photo,*/
            @PathVariable long id) {
        User user = (User) sesion.getAttribute("User");
        UserPersonalData upd = users.findOne(id);
        if (!email.isEmpty()) {
            upd.setEmail(email);
        }

        if (!username.isEmpty()) {
            upd.setUserName(username);
        }

        if (upd.getOldPassword() != oldPassword) {
            return "error";
        }
        if (!newPassword.isEmpty()) {
            upd.setOldPassword(newPassword);
            upd.setNewPassword(newPassword);
        }

        //upd.setPhoto(imagen);
        users.save(upd);

        user.setUser(upd);

        String fileName = upd.getId() + ".jpg";
        if (!imagen.isEmpty()) {
            try {

                File filesFolder = new File(FILES_FOLDER_USERS);
                if (!filesFolder.exists()) {
                    filesFolder.mkdirs();
                }

                File uploadedFile = new File(filesFolder.getAbsolutePath(), fileName);
                imagen.transferTo(uploadedFile);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        m.addAttribute("username", upd.getUserName());
        m.addAttribute("colaborateProjects", user.getColaborateProjects());
        m.addAttribute("otherProjects", user.getOtherProjects());
        m.addAttribute("movements", user.getDonations());
        m.addAttribute("User", upd);
        sesion.setAttribute("User", user);

        return "users";
    }

    @RequestMapping("/users/login")
    public String userLogin(Model m, UserLogin s, HttpSession sesion, HttpServletRequest request) {

        List<UserProject> userProject = new ArrayList<>();
        List<UserProject> otherProjects = new ArrayList<>();
        List<UserMovements> userMovements = new ArrayList<>();
        String emailRecieve = s.getEmail();
        String passwordRecieve = s.getPassword();

		///////
        List<UserPersonalData> data = users.findByEmailAndOldPassword(emailRecieve, passwordRecieve);
        if (!(data.size() == 0)) {
            long id = data.get(0).getId();
            List<Donation> donations = movements.findByuserId(id);
            List<Long> idDonateProjects = new ArrayList<>();

            for (Donation d : donations) {
                Project p = d.getProject();
                String title = p.getTitle();
                boolean find = false;
                for (UserProject us : userProject) {
                    if (us.getTitle() == title) {
                        us.setMoney(us.getMoney() + d.getMoney());
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    userProject.add(new UserProject(d.getProject().getId(), title, p.getShortDescription(), d.getMoney()));
                    idDonateProjects.add(d.getProject().getId());
                }
                userMovements.add(new UserMovements(title, d.getMoney(), d.getDate()));
            }

            long maximoID = projects.maxID();
            for (long i = 1; i <= maximoID; i++) {
                if (!idDonateProjects.contains(i)) {
                    Project p = projects.findOne(i);
                    otherProjects.add(new UserProject(p.getId(), p.getTitle(), p.getShortDescription(), p.getRestBudget()));
                }
            }

            User user = new User(userProject, otherProjects, userMovements, data.get(0));
            //User user = new User(data.get(0));
            sesion.setAttribute("User", user);

            m.addAttribute("username", user.getUser().getUserName());
            m.addAttribute("colaborateProjects", user.getColaborateProjects());
            m.addAttribute("otherProjects", user.getOtherProjects());
            m.addAttribute("movements", user.getDonations());
            m.addAttribute("User", user.getUser());
            if(!request.isUserInRole("USER")){
            	m.addAttribute("bienvenido", user.getUser().getUserName());
            	return "Bootstrap-Admin-Theme/index";
            }
            return "users";
        } else {
            m.addAttribute("malogin", true);
            return "login";
        }

    }

    @RequestMapping("/users/load")
    public String userChagerge(Model m, HttpSession sesion) {

        List<UserProject> userProject = new ArrayList<>();
        List<UserProject> otherProjects = new ArrayList<>();
        List<UserMovements> userMovements = new ArrayList<>();

        User u = (User) sesion.getAttribute("User");

        long id = u.getUser().getId();
        List<Donation> donations = movements.findByuserId(id);
        List<Long> idDonateProjects = new ArrayList<>();

        for (Donation d : donations) {
            Project p = d.getProject();
            String title = p.getTitle();
            boolean find = false;
            for (UserProject us : userProject) {
                if (us.getTitle() == title) {
                    us.setMoney(us.getMoney() + d.getMoney());
                    find = true;
                    break;
                }
            }
            if (!find) {
                userProject.add(new UserProject(d.getProject().getId(), title, p.getShortDescription(), d.getMoney()));
                idDonateProjects.add(d.getProject().getId());
            }
            userMovements.add(new UserMovements(title, d.getMoney(), d.getDate()));
        }

        long maximoID = projects.maxID();
        for (long i = 1; i <= maximoID; i++) {
            if (!idDonateProjects.contains(i)) {
                Project p = projects.findOne(i);
                otherProjects.add(new UserProject(p.getId(), p.getTitle(), p.getShortDescription(), p.getRestBudget()));
            }
        }

        User user = new User(userProject, otherProjects, userMovements, u.getUser());
        //User user = new User(u.getUser());
        sesion.setAttribute("User", user);

        m.addAttribute("username", user.getUser().getUserName());
        m.addAttribute("colaborateProjects", user.getColaborateProjects());
        m.addAttribute("otherProjects", user.getOtherProjects());
        m.addAttribute("movements", user.getDonations());
        m.addAttribute("User", user.getUser());

        return "users";

    }

    @RequestMapping("/user/close")
    public String closeSesion(Model m, HttpSession sesion) {
        sesion.setAttribute("User", null);
        return "login";
    }

    @RequestMapping("/login")
    public String login(Model m, HttpSession sesion) {
        User s = (User) sesion.getAttribute("User");

        if (s != null) {
            List<UserProject> userProject = new ArrayList<>();
            List<UserProject> otherProjects = new ArrayList<>();
            List<UserMovements> userMovements = new ArrayList<>();

            User u = (User) sesion.getAttribute("User");

            long id = u.getUser().getId();
            List<Donation> donations = movements.findByuserId(id);
            List<Long> idDonateProjects = new ArrayList<>();

            for (Donation d : donations) {
                Project p = d.getProject();
                String title = p.getTitle();
                boolean find = false;
                for (UserProject us : userProject) {
                    if (us.getTitle() == title) {
                        us.setMoney(us.getMoney() + d.getMoney());
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    userProject.add(new UserProject(d.getProject().getId(), title, p.getShortDescription(), d.getMoney()));
                    idDonateProjects.add(d.getProject().getId());
                }
                userMovements.add(new UserMovements(title, d.getMoney(), d.getDate()));
            }

            long maximoID = projects.maxID();
            for (long i = 1; i <= maximoID; i++) {
                if (!idDonateProjects.contains(i)) {
                    Project p = projects.findOne(i);
                    otherProjects.add(new UserProject(p.getId(), p.getTitle(), p.getShortDescription(), p.getRestBudget()));
                }
            }

            User user = new User(userProject, otherProjects, userMovements, u.getUser());
            //User user = new User(u.getUser());
            sesion.setAttribute("User", user);

            m.addAttribute("username", user.getUser().getUserName());
            m.addAttribute("colaborateProjects", user.getColaborateProjects());
            m.addAttribute("otherProjects", user.getOtherProjects());
            m.addAttribute("movements", user.getDonations());
            m.addAttribute("User", user.getUser());

            return "users";
        }
        return "login";
    }

    /*@RequestMapping("/users/logged/index")
     public String loggedIndex(Model m) {
     return "/";
     }
	
     @RequestMapping("/users/logged/about")
     public String loggedAbout(Model m) {
     return "about";
     }
	
     @RequestMapping("/users/logged/blog")
     public String loggedBlog(Model m) {
     return "blog_template";
     }
	
     @RequestMapping("/users/logged/new")
     public String loggedNew(Model m) {
     return "new_template";
     }
	
     @RequestMapping("/users/logged/projects")
     public String loggedProjects(Model m) {
     return "projects_template";
     }
	
     @RequestMapping("/users/logged/project")
     public String loggedProject(Model m) {
     return "oneProject";
     }*/
    @RequestMapping(value = "/register/create", method = RequestMethod.POST)

    public String NewUser(Model model, @RequestParam String aname, @RequestParam String lastName,
            @RequestParam String username, @RequestParam String aemail, @RequestParam String apass,
            @RequestParam String apass2/*, @RequestParam MultipartFile imagen/*, HttpSession sesion*/) {

        ArrayList<String> rol = new ArrayList<>();
        rol.add("USER");
        UserPersonalData u = new UserPersonalData(aname, lastName, aemail, username, apass, apass2, "icon.png", rol);

        users.save(u);

		//model.addAttribute("username",username);
		//User us = new User(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), u);
		//sesion.setAttribute("User", us);
		//return "index_template";
        /*	String fileName = u.getId() + ".jpg";
         if (!imagen.isEmpty()) {
         try {

         File filesFolder = new File(FILES_FOLDER_USERS);
         if (!filesFolder.exists()) {
         filesFolder.mkdirs();
         }

         File uploadedFile = new File(filesFolder.getAbsolutePath(), fileName);
         imagen.transferTo(uploadedFile);
         }catch(IllegalStateException e){
         e.printStackTrace();
         } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         }
         }*/
        return "login";
    }

    @RequestMapping("/imageu/{fileName}.jpg")
    public void handleFile(@PathVariable String fileName,
            HttpServletResponse res) throws FileNotFoundException, IOException {

        File file = new File(FILES_FOLDER_USERS, fileName + ".jpg");

        if (file.exists()) {
            res.setContentType("image/jpeg");
            res.setContentLength(new Long(file.length()).intValue());
            FileCopyUtils
                    .copy(new FileInputStream(file), res.getOutputStream());
        } else {
            res.sendError(404, "File" + fileName + "(" + file.getAbsolutePath()
                    + ") does not exist");
        }
    }

}
