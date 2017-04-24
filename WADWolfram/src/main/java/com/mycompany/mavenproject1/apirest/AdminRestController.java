/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.apirest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.mavenproject1.donation.DonationsRepository;
import com.mycompany.mavenproject1.noticias.NoticiasRepository;
import com.mycompany.mavenproject1.project.ProjectRepository;
import com.mycompany.mavenproject1.user.User;
import com.mycompany.mavenproject1.user.UserPersonalData;
import com.mycompany.mavenproject1.user.UserPersonalDataRepository;
import com.mycompany.mavenproject1.user.UserService;
import com.mycompany.mavenproject1.user.UserUpdate;

/**
 *
 * @author JuanAntonio
 */
@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

	
	@Autowired
	public NoticiasRepository noticias;

	@Autowired
	public ProjectRepository projects;

	@Autowired
	public UserPersonalDataRepository adminuser;

	@Autowired
	public DonationsRepository movements;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserPersonalData> NewAdmin(Model m, HttpSession sesion, @RequestBody UserPersonalData u) {

		if(u!=null){
			UserPersonalData upd= userService.createUser(u);
			return new ResponseEntity<UserPersonalData>(upd,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserPersonalData> UpdateAdmin(@PathVariable long id, @RequestBody UserUpdate upd, HttpSession sesion) {
		if (upd != null) {
			User user = (User) sesion.getAttribute("User");
			UserPersonalData upd2 = adminuser.findOne(id);
			if (upd2.getId()== user.getUser().getId()){
				if (upd.getEmail()!=null) {
					upd2.setEmail(upd.getEmail());
				}
				if (upd.getOldPassword()== null || !upd2.matchPassword(upd.getOldPassword())) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);				 
				}
				if (upd.getNewPassword()!=null) {
					upd2.setPasswordHash(upd.getNewPassword());
				}

				adminuser.save(upd2);

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

}
