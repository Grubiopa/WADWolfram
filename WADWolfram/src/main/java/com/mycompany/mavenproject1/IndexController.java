/*
 * To change this license header, choose License Headers in UserProject Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author TOSHIBA
 */
@Controller
public class IndexController {
	/*
	 * @Autowired private ProjectsRepository projects;
	 * 
	 * @Autowired private NewsRepository news;
	 */
	@Autowired
	public UserPersonalDataRepository anotheruser;

	@RequestMapping("/")
	public String ShowIndex(Model m) {
		/*
		 * List<Project> projectsList=projects.findAll(new PageRequest(1, 3));
		 * List<New> newsList=news.findAll(new PageRequest(1, 3));
		 * model.addAttribute("projects", projectsList);
		 * model.addAttribute("news", newsList); List<ProjectProgress>
		 * percentages=new ArrayList<>(); for(Project p: projects){
		 * ProjectProgress percentage=new ProjectProgress(p.getTitle(),
		 * p.calculateProgressPercentage()); percentages.add(percentage); }
		 * 
		 */
		return "index_template";
	}

	/*
	 * @RequestMapping ("/projects") public String ShowProjects(Model m){ return
	 * "projects_template"; }
	 * 
	 * @RequestMapping ("/blog") public String ShowBlog(Model m){ return
	 * "blog_template"; }
	 */
	@RequestMapping("/contact")
	public String ShowContact(Model m) {
		return "contact";
	}

	@RequestMapping("/about")
	public String ShowAbout(Model m) {
		return "about";
	}

	@RequestMapping("/register")
	public String ShowRegister(Model m) {
		return "register";
	}

	@RequestMapping(value = "/register/create", method = RequestMethod.POST)

	public String NewUser(Model model, @RequestParam String aname, @RequestParam String lastName,
			@RequestParam String username, @RequestParam String aemail, @RequestParam String apass,
			@RequestParam String apass2, HttpSession sesion) {

		ArrayList<String> rol = new ArrayList<>();
		rol.add("User");
		UserPersonalData u = new UserPersonalData(aname, lastName, username, aemail, apass, apass2, "i.jpg", rol);

		anotheruser.save(u);

		// model.addAttribute("username",username);

		User us = new User(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), u);

		sesion.setAttribute("User", us);

		return "index_template";

	}
}
