package com.mycompany.mavenproject1.apirest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
import com.mycompany.mavenproject1.user.UserService;
import com.mycompany.mavenproject1.user.UserUpdate;


@RestController
@RequestMapping("/api/user")
public class UserRestController {
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
	
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
	
	@RequestMapping("/login")
	public ResponseEntity<User> logIn(HttpSession sesion) {
		if (!userComponent.isLoggedUser()) {
			log.info("Not user logged");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			//UserPersonalData loggedUser = userComponent.getLoggedUser();
			//log.info("Logged as " + loggedUser.getName());
			//return new ResponseEntity<>(loggedUser, HttpStatus.OK);
			User user2 = userService.loadUser(sesion);
			return new ResponseEntity<>(user2, HttpStatus.OK);
		}
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserPersonalData> updateUser(@PathVariable long id, @RequestBody UserUpdate upd, HttpSession sesion) {
		
		if (upd != null) {
			User user = (User) sesion.getAttribute("User");
			UserPersonalData upd2 = users.findOne(id);
			if (upd2.getId()== user.getUser().getId()){
				if (upd.getEmail()!=null) {
					upd2.setEmail(upd.getEmail());
				}

				if (upd.getUsername()!=null) {
					upd2.setUserName(upd.getUsername());
				}
				
				if (upd.getOldPassword()== null || !upd2.matchPassword(upd.getOldPassword())) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);				 
				}
				if (upd.getNewPassword()!=null) {
					upd2.setPasswordHash(upd.getNewPassword());
				}

				users.save(upd2);

				user.setUser(upd2);
						
				sesion.setAttribute("User", user);

				return new ResponseEntity<>(upd2, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserPersonalData> NewUser(Model model, @RequestBody UserPersonalData user) {		
		if(user!=null){
			user.setRoles("ROLE_USER");
			users.save(user);
			UserPersonalData us = users.findOne(user.getId());
			return new ResponseEntity<UserPersonalData>(us,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	@RequestMapping("/logout")
	public ResponseEntity<Boolean> logOut(HttpSession session) {

		if (!userComponent.isLoggedUser()) {
			log.info("No user logged");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			session.invalidate();
			log.info("Logged out");
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
	}
	
	//NUEVOS
	@RequestMapping("/allMovements")
	public ResponseEntity<List<UserMovements>> movements(){
		UserPersonalData loggedUser = userComponent.getLoggedUser();
		List<Donation> donations =  movements.findByuserId(loggedUser.getId());
		List<UserMovements> userMovements = new ArrayList<>();
		for (Donation d : donations) {
			Project p = d.getProject();
			String title = p.getTitle();			
			userMovements.add(new UserMovements(title, d.getMoney(), d.getDate()));
		}
		return new ResponseEntity<List<UserMovements>>(userMovements, HttpStatus.OK);
		
	}
	
	@RequestMapping("/userProjects")
	public ResponseEntity<List<UserProject>> userProjects(){
		UserPersonalData loggedUser = userComponent.getLoggedUser();
		List<UserProject> userProject = userService.getUserProjects(loggedUser.getId());
		return new ResponseEntity<List<UserProject>>(userProject, HttpStatus.OK);
	}
	@RequestMapping("/otherProjects")
	public ResponseEntity<List<UserProject>> otherProjects(){
		UserPersonalData loggedUser = userComponent.getLoggedUser();
		List<UserProject> userProject = userService.getOtherProjects(loggedUser.getId());
		return new ResponseEntity<List<UserProject>>(userProject, HttpStatus.OK);
	}
	
}
