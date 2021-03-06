package com.mycompany.mavenproject1.apirest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.mavenproject1.donation.Donation;
import com.mycompany.mavenproject1.donation.UserMovement;
import com.mycompany.mavenproject1.project.Project;
import com.mycompany.mavenproject1.project.ProjectService;
import com.mycompany.mavenproject1.project.Project.Basico;
import com.mycompany.mavenproject1.project.Project.Donaciones;
import com.mycompany.mavenproject1.user.User;
import com.mycompany.mavenproject1.user.UserComponent;
import com.mycompany.mavenproject1.user.UserPersonalData;
import com.mycompany.mavenproject1.user.UserPersonalDataRepository;

@RestController
@RequestMapping(value = "/api")
public class ProjectRestController {

	@Autowired
	private ProjectService service;
	@Autowired
	private UserComponent userComponent;
	// private static final String FILES_FOLDER_PROJECTS = "files";
	@Autowired
	private UserPersonalDataRepository users;
	
	interface ProyectoDetalle extends Project.Basico, Project.Donaciones, Donation.Basico {
	}

	@JsonView(ProyectoDetalle.class)
	@RequestMapping("/project/{id}")
	public ResponseEntity<Project> viewProject(@PathVariable long id) {
		Project p = service.viewProject(id);
		if (p != null)
			return new ResponseEntity<>(p, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@JsonView(Project.Basico.class)
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Project>> viewAllProjects() {
		ArrayList<Project> l = (ArrayList<Project>) service.viewAllProjects();
		return new ResponseEntity<>(l, HttpStatus.OK);
	}

	@JsonView(ProyectoDetalle.class)
	@RequestMapping(value = "/project/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Project> deleteProject(@PathVariable long id) {
		Project p = service.deleteProject(id);
		if (p != null)
			return new ResponseEntity<>(p, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	//DONAR
	@JsonView(ProyectoDetalle.class)
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.PUT)
	public ResponseEntity<Project> donate(@PathVariable long projectId, HttpSession sesion, @RequestBody UserMovement m) {
		Date date = new Date();
		
		UserPersonalData loggedUser = userComponent.getLoggedUser();
		Project p = service.viewProject(projectId);
		Donation d = new Donation(loggedUser, p, m.getMoney(), date);
		
		service.donate(projectId, d);
		p = service.viewProject(projectId);
		if (p != null)
			return new ResponseEntity<>(p, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@JsonView(ProyectoDetalle.class)
	@RequestMapping(value = "/project", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Project addNewProject(@RequestBody Project project) {
		Project p = service.addNewProject(project);
		return p;
	
	}

}
