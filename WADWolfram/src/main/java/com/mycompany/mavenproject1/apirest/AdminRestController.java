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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	private UserPersonalDataRepository users;

	@Autowired
	private UserComponent userComponent;
	// -------------------karen lo comentó*-------------------------
	/*
	 * @RequestMapping("/") public String index(Model m, HttpSession sesion) {
	 * User u = (User) sesion.getAttribute("User"); if (u == null) { return
	 * "login"; } if(u.getUser().getRoles().get(0).equals("USER")){ return
	 * "error";
	 * 
	 * } m.addAttribute("bienvenido", u.getUser().getUserName()); return
	 * "Bootstrap-Admin-Theme/index"; }
	 */

	 @RequestMapping(value = "/Profile/create", method = RequestMethod.POST)
	  public ResponseEntity<User> NewAdmin(Model m,HttpSession sesion, @RequestParam String name, @RequestParam
	  String email, @RequestParam String password, @RequestParam String repeat_password,@RequestParam Boolean confirm) {
	  
	 User u = (User) sesion.getAttribute("User");
		 if(password.equals(repeat_password)){
				users.save(new UserPersonalData(name, "", email, name, password, repeat_password, "icon.png", "ROLE_ADMIN"));
				return new ResponseEntity<>(u, HttpStatus.OK);
				}
				
				else{
					return new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
				}
	 }
		 
	 

	@RequestMapping(value = "/Profile/update", method = RequestMethod.POST)
	public ResponseEntity<User> UpdateAdmin(Model m, HttpSession sesion, @RequestParam String memail, @RequestParam String mpassword,
			@RequestParam String mnew_password, @RequestParam String mrepeat_password) {

		User u = (User) sesion.getAttribute("User");
		UserPersonalData upd = u.getUser();
		if (!memail.isEmpty()) {
			upd.setEmail(memail);
		}

		if (!upd.matchPassword(mpassword)) {
			return new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
		}


		if (!mnew_password.isEmpty() && !mrepeat_password.isEmpty()) {
			if (mnew_password.equals(mrepeat_password)) {
				if (upd.matchPassword(mpassword)) {

					upd.setPasswordHash(mnew_password);
				} else {
					m.addAttribute("malpass2",true);
					m.addAttribute("User", upd);
					return new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
				}
			} else {
				m.addAttribute("malpass3",true);
				m.addAttribute("User", upd);
				return new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
			}
		}

		if ((!mnew_password.isEmpty() && mrepeat_password.isEmpty()) || (mnew_password.isEmpty() && !mrepeat_password.isEmpty() )){
			m.addAttribute("malpass3",true);
			m.addAttribute("User", upd);
			return new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
		}
		
		
		adminuser.save(upd);

		u.setUser(upd);

		sesion.setAttribute("User", u);

		return new ResponseEntity<>(u, HttpStatus.OK);
	}

}
