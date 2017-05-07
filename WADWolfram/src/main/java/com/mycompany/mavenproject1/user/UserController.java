package com.mycompany.mavenproject1.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import com.mycompany.mavenproject1.donation.Donation;
import com.mycompany.mavenproject1.donation.DonationsRepository;
import com.mycompany.mavenproject1.project.Project;
import com.mycompany.mavenproject1.project.ProjectRepository;

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
	@Autowired
	private UserComponent userComponent;
	@Autowired
	private UserService userService;

	private static final String FILES_FOLDER_USERS = "filesUsers";

	@RequestMapping(value = "/users/update/{id}", method = RequestMethod.POST)
	public String updateDB(Model m, HttpSession sesion, @RequestParam MultipartFile imagen, @RequestParam String email,
			@RequestParam String username, @RequestParam String oldPassword,
			@RequestParam String newPassword, /* @RequestParam String photo, */
			@PathVariable long id) {
		
		User user = (User) sesion.getAttribute("User");
		UserPersonalData upd = users.findOne(id);
		if (!email.isEmpty()) {
			upd.setEmail(email);
		}

		if (!username.isEmpty()) {
			upd.setUserName(username);
		}
		
		if (!upd.matchPassword(oldPassword)) {
			 m.addAttribute("matchpass", true);
				m.addAttribute("username", upd.getUserName());
				m.addAttribute("colaborateProjects", user.getColaborateProjects());
				m.addAttribute("otherProjects", user.getOtherProjects());
				m.addAttribute("movements", user.getDonations());
				m.addAttribute("User", upd);
				sesion.setAttribute("User", user);
			 return "users";
		}
		if (!newPassword.isEmpty()) {
			upd.setPasswordHash(newPassword);
		}

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
	public String userLogin(Model m, HttpSession sesion, HttpServletRequest request) {
		
		User user2 = userService.loadUser(sesion);
		if (!request.isUserInRole("USER")) {
			m.addAttribute("bienvenido", user2.getUser().getUserName());
			return "Bootstrap-Admin-Theme/index";
		}

		m.addAttribute("username", user2.getUser().getUserName());
		m.addAttribute("colaborateProjects", user2.getColaborateProjects());
		m.addAttribute("otherProjects", user2.getOtherProjects());
		m.addAttribute("movements", user2.getDonations());
		m.addAttribute("User", user2.getUser());
		return "users";

	}

	
	@RequestMapping("/login")
	public String login(Model m, HttpSession sesion, HttpServletRequest request) {
		//NO hay cambios ya que funciona y usamos la sesion probablemente si lo hacemos como en User/login funciona
		//pero abría que cambiar el codigo y creo que entonces la sesion sobraria
		User s = (User) sesion.getAttribute("User");
		
		if (s != null && request.isUserInRole("USER")) {
			List<UserProject> userProject = new ArrayList<>();
			List<UserProject> otherProjects = new ArrayList<>();
			List<UserMovements> userMovements = new ArrayList<>();

			//User u = (User) sesion.getAttribute("User");

			long id = s.getUser().getId();
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
					userProject
							.add(new UserProject(d.getProject().getId(), title, p.getShortDescription(), d.getMoney()));
					idDonateProjects.add(d.getProject().getId());
				}
				userMovements.add(new UserMovements(title, d.getMoney(), d.getDate()));
			}

			long maximoID = projects.maxID();
			for (long i = 1; i <= maximoID; i++) {
				if (!idDonateProjects.contains(i)) {
					Project p = projects.findOne(i);
					otherProjects
							.add(new UserProject(p.getId(), p.getTitle(), p.getShortDescription(), p.getRestBudget()));
				}
			}

			User user = new User(userProject, otherProjects, userMovements, s.getUser());
			sesion.setAttribute("User", user);

			m.addAttribute("username", user.getUser().getUserName());
			m.addAttribute("colaborateProjects", user.getColaborateProjects());
			m.addAttribute("otherProjects", user.getOtherProjects());
			m.addAttribute("movements", user.getDonations());
			m.addAttribute("User", user.getUser());

			return "users";
		}
	/*	CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		m.addAttribute("token", token.getToken());*/	
		return "login";
	}

	@RequestMapping(value = "/register/create", method = RequestMethod.POST)

	public String NewUser(Model model, @RequestParam String aname, @RequestParam String lastName,
			@RequestParam String username, @RequestParam String aemail, @RequestParam String apass,
			@RequestParam String apass2) {
		if(apass.equals(apass2)){
		users.save(
				new UserPersonalData(aname, lastName, aemail, username, apass, apass2, "icon.png", "ROLE_USER"));

		return "login";}
		
		else{
			model.addAttribute("contraseñaIncorrecta", true);
			return "register";}
		
	}
	

	@RequestMapping("/imageu/{fileName}.jpg")
	public void handleFile(@PathVariable String fileName, HttpServletResponse res)
			throws FileNotFoundException, IOException {

		File file = new File(FILES_FOLDER_USERS, fileName + ".jpg");

		if (file.exists()) {
			res.setContentType("image/jpeg");
			res.setContentLength(new Long(file.length()).intValue());
			FileCopyUtils.copy(new FileInputStream(file), res.getOutputStream());
		} else {
			res.sendError(404, "File" + fileName + "(" + file.getAbsolutePath() + ") does not exist");
		}
	}	
	

}
