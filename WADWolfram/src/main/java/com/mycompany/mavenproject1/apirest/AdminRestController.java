/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.apirest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.mavenproject1.donation.Donation;
import com.mycompany.mavenproject1.donation.DonationsRepository;
import com.mycompany.mavenproject1.noticias.Noticia;
import com.mycompany.mavenproject1.noticias.NoticiasRepository;
import com.mycompany.mavenproject1.project.Project;
import com.mycompany.mavenproject1.project.ProjectRepository;
import com.mycompany.mavenproject1.user.User;
import com.mycompany.mavenproject1.user.UserComponent;
import com.mycompany.mavenproject1.user.UserPersonalData;
import com.mycompany.mavenproject1.user.UserPersonalDataRepository;
import com.mycompany.mavenproject1.user.UserService;

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
	private UserComponent userComponent;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/Profile/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserPersonalData> NewAdmin(Model m, HttpSession sesion, @RequestBody UserPersonalData u) {

		if(u!=null){
			adminuser.save(u);
			return new ResponseEntity<UserPersonalData>(u,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/Profile/update", method = RequestMethod.PUT)
	public ResponseEntity<User> UpdateAdmin(Model m, HttpSession sesion, @RequestBody User u) {

		UserPersonalData upd = u.getUser();
		if (!upd.getEmail().isEmpty()) {
			upd.setEmail(upd.getEmail());
		}

		if (!upd.matchPassword(upd.getPasswordHash())) {
			return new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
		}

		if (!upd.getPasswordHash().isEmpty() && upd.matchPassword(upd.getPasswordHash())) {
			upd.setPasswordHash(upd.getPasswordHash());
		} else {
			return new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
		}

		
		u.setUser(upd);
		
		sesion.setAttribute("User", u);
		
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

}
