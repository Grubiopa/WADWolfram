package com.mycompany.mavenproject1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

@Autowired
private ProjectsRepository projects;

@RequestMapping("/project")
public String viewProject(Model model, @requestParam int id){
Project p=projects.findOne(id);
model.addAttribute("project", p);
return "oneProject";
}

@RequestMapping("/allProjects", method = RequestMethod.GET)
public String viewAllProjects(Model model){
List<Project> l=projects.findAll();
model.addAttribute("projects", l);
return "projects_template";
}

@RequestMapping("/load", method = RequestMethod.POST)
public void loadProject(@requestParam String title, @requestParam String image, @requestParam String description, @requestParam String shortDescription, @requestParam Date releaseDate, @requestParam double totalBudget, @requestParam double parcialBudget, @requestParam double time, @requestParam int startYear){
Project p=new Project(tittle, shortDescription, description, totalBudget, parcialBudget, time, opened, releaseDate, startYear, image);
projects.save(p);
}

@RequestMapping("/", method = RequestMethod.DELETE)
public void deleteProject(@requestParam long id){
Project p=projects.findOne(id);
projects.delete(p);
}


/*

	@RequestMapping ("/project")
	public String loadProject(Model m){
		int id=0;
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
*/	
	@RequestMapping("/pay")
	public String donate(Model m, int projectId){
		//projectId es el id para reconocer al proyecto que se dona
		
		return "pay";
	}
}
