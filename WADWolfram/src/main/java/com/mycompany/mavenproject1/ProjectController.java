package com.mycompany.mavenproject1;

import java.util.Date;
import java.util.List;

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

	@RequestMapping("/project")
	public String viewProject(Model model, @RequestParam int id) {
		Project p = projects.findById(id);
		model.addAttribute("project", p);
		return "oneProject";
	}

	@RequestMapping(value = "/allProjects", method = RequestMethod.GET)
	public String viewAllProjects(Model model) {
		List<Project> l = projects.findAll();
		model.addAttribute("projects", l);
		return "projects_template";
	}

	@RequestMapping(value = "/loadProject", method = RequestMethod.POST)
	public void loadProject(@RequestParam String title, @RequestParam String image, @RequestParam String description,
			@RequestParam String shortDescription, @RequestParam Boolean opened, @RequestParam Date releaseDate,
			@RequestParam double totalBudget, @RequestParam double parcialBudget, @RequestParam double time,
			@RequestParam int startYear) {
		Project p = new Project(title, shortDescription, description, totalBudget, parcialBudget, time, opened,
				releaseDate, startYear, image);
		projects.save(p);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteProject(@RequestParam long id) {
		Project p = projects.findOne(id);
		projects.delete(p);
	}

	/*
	 * 
	 * @RequestMapping ("/project") public String loadProject(Model m){ long
	 * id=0; String title = "title"; String shortDescription="shortDescription";
	 * String description = "description"; Double totalBudget = 50.0; Double
	 * parcialBudget = 0.0; String type = "type"; String startYear = "year";
	 * String image = "image"; Project p = new Project(id, title,
	 * shortDescription, description, totalBudget, parcialBudget, type,
	 * startYear, image); m.addAttribute("Project", p); return "oneProject"; }
	 */
	@RequestMapping("/pay")
	public String donate(Model m, long projectId) {
		// projectId es el id para reconocer al proyecto que se dona

		return "pay";
	}
}
