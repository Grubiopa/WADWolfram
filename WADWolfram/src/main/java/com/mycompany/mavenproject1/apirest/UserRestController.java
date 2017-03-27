package com.mycompany.mavenproject1.apirest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.mavenproject1.donation.Donation;
import com.mycompany.mavenproject1.donation.DonationsRepository;
import com.mycompany.mavenproject1.project.Project;
import com.mycompany.mavenproject1.project.ProjectRepository;
import com.mycompany.mavenproject1.user.User;
import com.mycompany.mavenproject1.user.UserComponent;
import com.mycompany.mavenproject1.user.UserMovements;
import com.mycompany.mavenproject1.user.UserPersonalData;
import com.mycompany.mavenproject1.user.UserPersonalDataRepository;
import com.mycompany.mavenproject1.user.UserProject;


@RestController
@RequestMapping("/api/users")
public class UserRestController {
	@Autowired
	private UserPersonalDataRepository users;
	@Autowired
	private ProjectRepository projects;
	@Autowired
	private DonationsRepository movements;
	@Autowired
	private UserComponent userComponent;
	
	@RequestMapping("/login")
	public ResponseEntity<User> userLogin(Model m, HttpSession sesion, HttpServletRequest request) {
		//Aqui es a donde va a redirigir una vez el login sea efectivo, no puede llamarse solo login tambien
		//por eso se tiene que "repetir" el codigo de /login ya que nosotros lo usamos para los enlaces
		
		List<UserProject> userProject = new ArrayList<>();
		List<UserProject> otherProjects = new ArrayList<>();
		List<UserMovements> userMovements = new ArrayList<>();
		
		//UserComponent te da ya al usuario en accion pero me han dicho que si lo usas directamente muchas veces da
		//problemas, que es mejor hacerlo asi.
		
		UserPersonalData user = users.findByEmail(userComponent.getLoggedUser().getEmail());

		List<Donation> donations = movements.findByuserId(user.getId());
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

		User user2 = new User(userProject, otherProjects, userMovements, user);
		sesion.setAttribute("User", user2);
		return new ResponseEntity<>(user2, HttpStatus.OK);
	}
}
