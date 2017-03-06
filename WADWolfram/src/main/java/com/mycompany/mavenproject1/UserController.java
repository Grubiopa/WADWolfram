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
		List<Role> role = new ArrayList<>();
		role.add(Role.ADMIN);
		users.save(new UserPersonalData("Gabi", "R", "g.ru@yo.com", "gabi0794", "aaaa", "aaaa", "icon.png", role));
		users.save(new UserPersonalData("TU", "t", "t.ru@yo.com", "tu", "bbbb", "bbbb", "icon.png", role));
		Date d = new Date();
		movements.save(new Donation(1, 1, 50, d));
		movements.save(new Donation(1, 1, 60, d));
		movements.save(new Donation(1, 1, 40, d));
		movements.save(new Donation(1, 2, 10, d));
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
			System.out.println(id);
			System.out.println(movements.count());
			
			List<Donation> donations = movements.findByuserId(id);
			List<Long> idDonateProjects = new ArrayList<>();

			for (Donation d : donations) {
				Project p = projects.findOne(d.getProjectId());
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
					userProject.add(new UserProject(title, p.getShortDescription(), d.getMoney()));
					idDonateProjects.add(d.getProjectId());
				}
				userMovements.add(new UserMovements(title, d.getMoney(), d.getDate()));
			}

			long maximoID = projects.maxID();
			for (long i = 1; i <= maximoID; i++) {
				if (!idDonateProjects.contains(i)) {
					Project p = projects.findOne(i);
					otherProjects.add(new UserProject(p.getTitle(), p.getShortDescription(), p.getRestBudget()));
				}
			}

			User user = new User(userProject, otherProjects, userMovements, data.get(0));
			sesion.setAttribute("User", user);

			m.addAttribute("username", user.getUser().getUserName());
			m.addAttribute("colaborateProjects", user.getColaborateProjects());
			m.addAttribute("otherProjects", user.getOtherProjects());
			m.addAttribute("movements", user.getUserMovements());
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

	@RequestMapping("/login")
	public String login(Model m) {
		return "login";
	}

}