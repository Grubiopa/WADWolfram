package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		p = projects.findOne((long) 2);
		movements.save(new Donation(u, p, 10, d));
	}

	@RequestMapping("/users/update")
	public String updateDB(Model m, UserPersonalData u) {
		// Consulta SQL de update
		return "users";
	}

	@RequestMapping("/users/login")
	public String userLogin(Model m, UserLogin s, HttpSession sesion) {

		List<UserProject> userProject = new ArrayList<>();
		List<UserProject> otherProjects = new ArrayList<>();
		List<UserMovements> userMovements = new ArrayList<>();
		String emailRecieve = s.getEmail();
		String passwordRecieve = s.getPassword();

		///////

		List<UserPersonalData> data = users.findByEmailAndOldPassword(emailRecieve, passwordRecieve);
		if (!(data.size()==0)) {
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
					userProject.add(new UserProject(d.getProject().getId(),title, p.getShortDescription(), d.getMoney()));
					idDonateProjects.add(d.getProject().getId());
				}
				userMovements.add(new UserMovements(title, d.getMoney(), d.getDate()));
			}

			long maximoID = projects.maxID();
			for (long i = 1; i <= maximoID; i++) {
				if (!idDonateProjects.contains(i)) {
					Project p = projects.findOne(i);
					otherProjects.add(new UserProject(p.getId(),p.getTitle(), p.getShortDescription(), p.getRestBudget()));
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
		} else {
			m.addAttribute("username", "fallo");
			m.addAttribute("colaborateProjects", userProject);
			m.addAttribute("otherProjects", otherProjects);
			m.addAttribute("movements", userMovements);
			m.addAttribute("User", new UserPersonalData());
		}
		
		return "users";

	}
	
	/*@RequestMapping("/users/load")
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
					userProject.add(new UserProject(d.getProject().getId(),title, p.getShortDescription(), d.getMoney()));
					idDonateProjects.add(d.getProject().getId());
				}
				userMovements.add(new UserMovements(title, d.getMoney(), d.getDate()));
			}

			long maximoID = projects.maxID();
			for (long i = 1; i <= maximoID; i++) {
				if (!idDonateProjects.contains(i)) {
					Project p = projects.findOne(i);
					otherProjects.add(new UserProject(p.getId(),p.getTitle(), p.getShortDescription(), p.getRestBudget()));
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

	}*/
	
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
						userProject.add(new UserProject(d.getProject().getId(),title, p.getShortDescription(), d.getMoney()));
						idDonateProjects.add(d.getProject().getId());
					}
					userMovements.add(new UserMovements(title, d.getMoney(), d.getDate()));
				}

				long maximoID = projects.maxID();
				for (long i = 1; i <= maximoID; i++) {
					if (!idDonateProjects.contains(i)) {
						Project p = projects.findOne(i);
						otherProjects.add(new UserProject(p.getId(),p.getTitle(), p.getShortDescription(), p.getRestBudget()));
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
	
	
	
	

}