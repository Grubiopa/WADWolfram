package com.mycompany.mavenproject1.apirest;

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
import com.mycompany.mavenproject1.user.UserService;



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
	@Autowired
	private UserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
	@RequestMapping("/load")
	public ResponseEntity<User> userLogin(HttpSession sesion) {
		
		User user2 = userService.loadUser(sesion);
		return new ResponseEntity<>(user2, HttpStatus.OK);
	}
	@RequestMapping("/login")
	public ResponseEntity<UserPersonalData> logIn() {

		if (!userComponent.isLoggedUser()) {
			log.info("Not user logged");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			UserPersonalData loggedUser = userComponent.getLoggedUser();
			log.info("Logged as " + loggedUser.getName());
			return new ResponseEntity<>(loggedUser, HttpStatus.OK);
		}
	}
}
