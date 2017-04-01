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
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserPersonalData> updateUser(@PathVariable long id, @RequestBody UserPersonalData upd, HttpSession sesion) {
		System.out.println(upd.getName());
		System.out.println(upd.getPasswordHash());
		if (upd != null) {
			User user = (User) sesion.getAttribute("User");
			UserPersonalData upd2 = users.findOne(id);
			if (!upd.getEmail().isEmpty()) {
				upd2.setEmail(upd.getEmail());
			}

			if (!upd.getUserName().isEmpty()) {
				upd2.setUserName(upd.getUserName());
			}
			
			if (!upd.matchPassword(upd.getPasswordHash())) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);				 
			}
			if (!upd.getPasswordHash().isEmpty()) {
				upd2.setPasswordHash(upd.getPasswordHash());
			}

			users.save(upd2);

			user.setUser(upd2);

			/*String fileName = upd2.getId() + ".jpg";
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
			}*/

			
			sesion.setAttribute("User", user);

			return new ResponseEntity<>(upd2, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/register/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserPersonalData> NewUser(Model model, @RequestBody UserPersonalData user) {		
		if(user!=null){			
			users.save(user);
			return new ResponseEntity<UserPersonalData>(user,HttpStatus.OK);
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
}
