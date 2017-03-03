package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author TOSHIBA
 */
@Controller
public class UserController {
	
	@Autowired
		private UserPersonalDataRepository users;
		private ProjectRepository projects;
		private MovementsRepository movements;
		
	@PostConstruct
	public void init() {
		List<Role> role = new ArrayList<>();
		role.add(Role.ADMIN);
		users.save(new UserPersonalData("Gabi","R","g.ru@yo.com","gabi0794","aaaa","aaaa","icon.png",role));
		users.save(new UserPersonalData("TU","t","t.ru@yo.com","tu","bbbb","bbbb","icon.png",role));
	}
	
	@RequestMapping("/users/update")
	public String updateDB(Model m, UserPersonalData u) {
		// Consulta SQL de update
		return "users";
	}

	@RequestMapping ("/users/login")
	public String userLogin (Model m, UserLogin s, HttpSession sesion){
		
		
	List<UserProject> userProject = new ArrayList<>();
	List<UserProject> otherProjects = new ArrayList<>();
	List<UserMovements> userMovements = new ArrayList<>();
	String emailRecieve = s.getEmail();
	String passwordRecieve = s.getPassword();
	
	/*Se realizara la consulta a la bbdd para obtener todos los datos personales del usuario.
	*Se guardaran en UserPersonal data = RepuestaQuery;
	*/
	/*Una vez obtenido el usuario
	 * userMovements = Query a movimientos que obtenga los id de los proyectos en los que participa el usuario
	 * Sacar la suma del dinero del usuario en otra query por proyecto
	 * Buce hasta que no queden proyectos en la lista
	 * userProject.add(new UserProject(proyects.findOne(id).title,proyects.findOne(id).shortDescription,SumaDinero) 
	 */
	/*
	 * Query que diga el numero maxmo de projectos
	 * Bucle for hasta ese numero
	 * Si ese id no esta en la lista obtenida antes hacer esto
	 * otherProjects.add(new UserProjects(proyects.findOne(id).title,proyects.findOne(id).shortDescription,0)
	 */
	//crear User user = new User(userProject, otherProject,userMovements,data);
	//sesion.setAttribute("User", user);
	List<Role> role = new ArrayList<>();
	role.add(Role.ADMIN);
	User user = new User(userProject,otherProjects,userMovements,new UserPersonalData("Gabi","R","g.ru@yo.com","gabi0794","aaaa","aaaa","icon.png",role));
	sesion.setAttribute("User", user);
	m.addAttribute("username",user.getUser().getUserName());
	m.addAttribute("colaborateProjects", user.getColaborateProjects());
	m.addAttribute("otherProjects", user.getOtherProjects());
	m.addAttribute("movements", user.getUserMovements());
	m.addAttribute("User", user.getUser());
	return "users";			
		
	}

	@RequestMapping("/login")
	public String login(Model m) {
		return "login";
	}
	
}