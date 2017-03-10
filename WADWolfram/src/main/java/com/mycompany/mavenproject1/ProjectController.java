package com.mycompany.mavenproject1;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {

	@Autowired
	private ProjectRepository projects;
	@Autowired
	private DonationsRepository movements;

	@PostConstruct
	public void init() {
		Date releaseDate = new Date();
		projects.save(new Project("Titulo", "Breve Descripcion", "description", 50.0, 0.0, 36, true, releaseDate, 2017,
				"image"));
		projects.save(new Project("Titulo2", "Breve Descripcion2", "description2", 50.0, 0.0, 36, true, releaseDate,
				2017, "image"));
	}

	@RequestMapping("/project")
	
	public String viewProject(Model model, @RequestParam long id) {
		Project p = projects.findOne(id);
		model.addAttribute("Project", p);
		return "oneProject";
	}

	/// ESTO SACARIA TODOS LOS PROYECTOS
	/*
	 * public String viewProject2(Model model){ model.addAttribute("Project",
	 * projects.findAll()); return "oneProject"; }
	 */

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String viewAllProjects(Model model) {
		List<Project> l = projects.findAll();
		model.addAttribute("projects", l);
		return "projects_template";
	}

	

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteProject(@RequestParam long id) {
		Project p = projects.findOne(id);
		projects.delete(p);
	}
	
	@RequestMapping("/pay")
	public String donate(Model m, int projectId, HttpSession sesion) {
		// projectId es el id para reconocer al proyecto que se dona
		User s = (User) sesion.getAttribute("User");

		if (s != null) {
			m.addAttribute("User", s.getUser());
			return "pay";
		} else {
			return "login";
		}

	}

	
	@RequestMapping("/pay/projects")
	public String donate(Model m, long projectId, HttpSession sesion, double money) {
		Date d = new Date();
		User s = (User) sesion.getAttribute("User");
		Project p  = projects.findOne(projectId);
		movements.save(new Donation(s.getUser(), p, money, d));
		return "project";
	}
	
	
	@RequestMapping(value="/admin/AddProject/create", method=RequestMethod.POST)
	public String addNewProject(@RequestParam String title,@RequestParam String shortDescription,
			@RequestParam String description,@RequestParam double totalBudget,@RequestParam double parcialBudget,
			@RequestParam double time,@RequestParam String releaseDate,@RequestParam boolean opened,
			@RequestParam int startYear,@RequestParam String image){
		
		Date date= new Date();
		Project p= new Project(title, shortDescription, description, totalBudget, parcialBudget, time, true, date, startYear, image);
		projects.save(p);
                
                return "Bootstrap-Admin-Theme/index";
		
	}
	
}

