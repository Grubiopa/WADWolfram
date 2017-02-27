package com.mycompany.mavenproject1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {
	
	@RequestMapping ("/project")
	public String loadProject(Model m){
		long id=0;
		String title = "title";
		String shortDescription="shortDescription";
		String description = "description";
		Double totalBudget = 50.0;
		Double parcialBudget = 0.0;		
		String type = "type";
		String startYear = "year";
		String image = "image";
		Project p = new Project(id, title, shortDescription, description, totalBudget, parcialBudget, type, startYear, image);
		m.addAttribute("Project", p);
		return "oneProject";
	}
	
	@RequestMapping("/pay")
	public String donate(Model m, long projectId){
		//projectId es el id para reconocer al proyecto que se dona
		
		return "pay";
	}
}
