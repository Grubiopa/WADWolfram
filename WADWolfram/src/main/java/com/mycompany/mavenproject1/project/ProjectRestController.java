package com.mycompany.mavenproject1;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value="/api")
public class ProjectRestController {

	@Autowired
	private ProjectService service;
	
//	private static final String FILES_FOLDER_PROJECTS = "files";

	interface ProyectoDetalle extends Project.Basico, Project.Donaciones, Donation.Basico{}
	@JsonView(ProyectoDetalle.class)
	@RequestMapping("/project/{id}")
	public ResponseEntity<Project> viewProject(@PathVariable 			long id) {
			Project p = service.viewProject(id);
	if (p!=null)		
			   return new ResponseEntity<>(p, HttpStatus.OK);
	else
		   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	@JsonView(Project.Basico.class)
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public List<Project> viewAllProjects(			) {
		List<Project> l =service.viewAllProjects();
				return l;
	}

	@JsonView(ProyectoDetalle.class)
	@RequestMapping(value = "/borrarProyecto/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Project> deleteProject(@PathVariable 			long 		id) {
		Project p = service.deleteProject(id);
		if(p!=null)
   			return new ResponseEntity<>(p, HttpStatus.OK);
		else
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

//revisar
	@JsonView(ProyectoDetalle.class)
	@RequestMapping(value="/pay/projects", method=RequestMethod.PUT)
	public ResponseEntity<Project> donate(@RequestParam 			long projectId, HttpSession sesion, @						RequestBody 		Donation	 d) {
		User s = (User) sesion.getAttribute("User");
				service.donate(projectId,  s,  d);
Project p=service.viewProject(projectId)				;
if (p!=null)
   	return new ResponseEntity<>(p, HttpStatus.OK);
else
   	return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@JsonView(ProyectoDetalle.class)
	@RequestMapping(value=	"/admin/AddProject/create", method=RequestMethod.POST)
		@ResponseStatus(HttpStatus.CREATED)
		public Project addNewProject(@RequestBody Project project){
Project p=service.addNewProject(project);
return p;		
/*
 		String fileName = p.getId() + ".jpg";
 		if (!imagen.isEmpty()) {
			try {

				File filesFolder = new File(FILES_FOLDER_PROJECTS);
				if (!filesFolder.exists()) {
					filesFolder.mkdirs();
				}

				File uploadedFile = new File(filesFolder.getAbsolutePath(), fileName);
				imagen.transferTo(uploadedFile);
			}catch(IllegalStateException e){
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
*/		
	}
	
/*
@RequestMapping("/imagep/{fileName}.jpg")
		public void handleFileDownload(@PathVariable String fileName,
				HttpServletResponse res) throws FileNotFoundException, IOException {

			File file = new File(FILES_FOLDER_PROJECTS, fileName+".jpg");

			if (file.exists()) {
				res.setContentType("imagep/jpeg");
				res.setContentLength(new Long(file.length()).intValue());
				FileCopyUtils
						.copy(new FileInputStream(file), res.getOutputStream());
			} else {
				res.sendError(404, "File" + fileName + "(" + file.getAbsolutePath()
						+ ") does not exist");
			}
		}
*/	
	
}

