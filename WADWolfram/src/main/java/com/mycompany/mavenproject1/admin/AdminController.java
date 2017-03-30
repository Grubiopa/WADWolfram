/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
@Controller
@RequestMapping("/admin")
public class AdminController {

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
	
	@RequestMapping("/")
	public String home(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN")) {
			model.addAttribute("bienvenido", users.findByEmail(userComponent.getLoggedUser().getEmail()).getUserName());
			return "Bootstrap-Admin-Theme/index";
		}
		return "login";
	}

	@RequestMapping("/AddBlog")
	public String addblog(Model m) {
		List<Noticia> not = noticias.findAll();
		m.addAttribute("noticias", not);
		return "Bootstrap-Admin-Theme/addblog";
	}

	@RequestMapping("/AddProject")
	public String addproject(Model m) {
		List<Project> proj = projects.findAll();
		m.addAttribute("projects", proj);
		return "Bootstrap-Admin-Theme/addproject";
	}

	@RequestMapping("/Donations")
	public String donations(Model m) {
		List<Donation> don = movements.findAll();
		m.addAttribute("donaciones", don);
		return "Bootstrap-Admin-Theme/donations";
	}

	@RequestMapping("/Profile")
	public String profile(Model m, HttpSession sesion) {
		User u = (User) sesion.getAttribute("User");
		m.addAttribute("User", u.getUser());
		
		return "Bootstrap-Admin-Theme/profile";
	}

	 @RequestMapping(value = "/Profile/create", method = RequestMethod.POST)
	  public String NewAdmin(Model m,HttpSession sesion, @RequestParam String name, @RequestParam
	  String email, @RequestParam String password, @RequestParam String repeat_password,@RequestParam Boolean confirm) {
	  
	 User u = (User) sesion.getAttribute("User");
		 if(password.equals(repeat_password)){
				users.save(new UserPersonalData(name, "", email, name, password, repeat_password, "icon.png", "ROLE_ADMIN"));
				m.addAttribute("UsuarioCreado", true);
				m.addAttribute("User", u.getUser());
				return "/Bootstrap-Admin-Theme/profile";
				}
				
				else{
					m.addAttribute("contraseñaIncorrecta", true);
					m.addAttribute("User", u.getUser());
					return "/Bootstrap-Admin-Theme/profile";
					}
	 }
		 
	 

	@RequestMapping(value = "/Profile/update", method = RequestMethod.POST)
	public String UpdateAdmin(Model m, HttpSession sesion, @RequestParam String memail, @RequestParam String mpassword,
			@RequestParam String mnew_password, @RequestParam String mrepeat_password) {

		User u = (User) sesion.getAttribute("User");
		UserPersonalData upd = u.getUser();
		if (!memail.isEmpty()) {
			upd.setEmail(memail);
		}

		if (!upd.matchPassword(mpassword)) {
			m.addAttribute("malpass1",true);
			m.addAttribute("User", upd);
			return "/Bootstrap-Admin-Theme/profile";
		}


		if (!mnew_password.isEmpty() && !mrepeat_password.isEmpty()) {
			if (mnew_password.equals(mrepeat_password)) {
				if (upd.matchPassword(mpassword)) {

					upd.setPasswordHash(mnew_password);
				} else {
					m.addAttribute("malpass2",true);
					m.addAttribute("User", upd);
					return "/Bootstrap-Admin-Theme/profile";
				}
			} else {
				m.addAttribute("malpass3",true);
				m.addAttribute("User", upd);
				return "/Bootstrap-Admin-Theme/profile";
			}
		}

		if ((!mnew_password.isEmpty() && mrepeat_password.isEmpty()) || (mnew_password.isEmpty() && !mrepeat_password.isEmpty() )){
			m.addAttribute("malpass3",true);
			m.addAttribute("User", upd);
			return "/Bootstrap-Admin-Theme/profile";
		}
		
		
		adminuser.save(upd);

		u.setUser(upd);

		sesion.setAttribute("User", u);

		m.addAttribute("bienvenido", upd.getUserName());
		return "Bootstrap-Admin-Theme/index";
	}

}
