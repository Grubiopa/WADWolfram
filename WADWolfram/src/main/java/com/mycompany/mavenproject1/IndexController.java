/*
 * To change this license header, choose License Headers in UserProject Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.mavenproject1.noticias.Noticia;
import com.mycompany.mavenproject1.noticias.NoticiasRepository;
import com.mycompany.mavenproject1.project.Project;
import com.mycompany.mavenproject1.project.ProjectProgress;
import com.mycompany.mavenproject1.project.ProjectRepository;

/**
 *
 * @author TOSHIBA
 */
@Controller
public class IndexController {
	
	 @Autowired private ProjectRepository projects;
	  
	 @Autowired private NoticiasRepository news;
	 
	

	@RequestMapping("/")
	public String ShowIndex(Model m) {
		
		List<Project> projectsList = projects.findAll();
		List<Noticia> newsList = news.findAll();
		List<ProjectProgress>percentages=new ArrayList<>(); 
		for(Project p: projectsList){
		ProjectProgress percentage=new ProjectProgress(p.getTitle(), p.calculateProgressPercentage());
		System.out.println(p.calculateProgressPercentage());
		percentages.add(percentage);
		} 
		 m.addAttribute("projects", projectsList);
		 m.addAttribute("news", newsList);		 
		 m.addAttribute("percentages",percentages);
		return "index_template";
	}
	
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
}
