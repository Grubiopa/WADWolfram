package com.mycompany.mavenproject1.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mycompany.mavenproject1.donation.Donation;
import com.mycompany.mavenproject1.donation.DonationsRepository;
import com.mycompany.mavenproject1.project.Project;
import com.mycompany.mavenproject1.project.ProjectRepository;

@Service
public class UserService {
	@Autowired
	private UserPersonalDataRepository users;
	@Autowired
	private ProjectRepository projects;
	@Autowired
	private DonationsRepository movements;
	@Autowired
	private UserComponent userComponent;

	public User loadUser(HttpSession sesion) {
		List<UserProject> userProject = new ArrayList<>();
		List<UserProject> otherProjects = new ArrayList<>();
		List<UserMovements> userMovements = new ArrayList<>();

		// UserComponent te da ya al usuario en accion pero me han dicho que si
		// lo usas directamente muchas veces da
		// problemas, que es mejor hacerlo asi.

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
		return user2;
	}
	
	
	public List<UserProject> getUserProjects(long id){
		List<UserProject> userProject = new ArrayList<>();		
		List<Donation> donations =  movements.findByuserId(id);
		
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
			}			
		}
		return userProject;
	}
	
	public List<UserProject> getOtherProjects(long id){
		List<UserProject> userProject = new ArrayList<>();
		List<UserProject> otherProjects = new ArrayList<>();
		List<UserMovements> userMovements = new ArrayList<>();
		
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
		
		return otherProjects;
		
	}
	
	public UserPersonalData createUser(UserPersonalData u) {
		users.save(u);
		return u;
	}

	/*public UserPersonalData updateUser(UserPersonalData upd,UserPersonalData u) {
		upd.setName(u.getName());
		upd.setEmail(u.getEmail());
		upd.setLastname(u.getLastname());
		upd.setPasswordHash(u.getPasswordHash());		
		upd.setUserName(u.getUserName());
		users.save(upd);
		return upd;
	}*/
}
