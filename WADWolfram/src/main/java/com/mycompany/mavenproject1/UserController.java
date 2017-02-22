package com.mycompany.mavenproject1;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author TOSHIBA
 */
@Controller
public class UserController {
    @RequestMapping ("/users")
    public String saludo(Model m){
	    List<UserProject> userProject = new ArrayList<>();
	    List<UserProject> otherProjects = new ArrayList<>();
	    List<UserMovements> userMovements = new ArrayList<>();
	    
	    for (int i = 0;i<4;i++){
	    	userProject.add(new UserProject("proyecto"+i,"Soy el proyecto" +i, (50.2*i)+1));
	    	userMovements.add(new UserMovements("proyecto"+i, 50.2*i, new Date(2017, 1, 15)));
	    	otherProjects.add(new UserProject("proyecto"+(i+1)*2,"Soy el proyecto" +(i+1)*2, 0.0));
	    }
	    
	    User user = new User(userProject, otherProjects,userMovements, new UserPersonalData("Gabi", "Rubio", "y@gmail.com", "gabi0794", "1234", "Nueva contraseña", "icon.png"));
	    
	    
	    m.addAttribute("username", user.getUser().getName());
	    m.addAttribute("colaborateProjects", user.getColaborateProjects());
	    m.addAttribute("otherProjects", user.getOtherProjects());
	    m.addAttribute("movements", user.getUserMovements());
	    m.addAttribute("User", user.getUser());	    
	    return "users";
    
   
    }
    @RequestMapping ("/users/update")
    	public String updateDB(Model m, UserPersonalData u){
    	//Consulta SQL de update
    	return "users";
    }
    
    @RequestMapping ("/users/login")
    	public String userLogin (Model m, UserLogin s){
    		
    	List<UserProject> userProject = new ArrayList<>();
		List<UserProject> otherProjects = new ArrayList<>();
		List<UserMovements> userMovements = new ArrayList<>();
		String emailRecieve = s.getEmail();
		String passwordRecieve = s.getPassword();
		
		//SQL
		
		//Si la sql falla return login else (hacemos esto)
    	User user = new User(userProject, otherProjects,userMovements, new UserPersonalData("Gabi", "Rubio", "y@gmail.com", "gabi0794", "1234", "Nueva contraseña", "icon.png"));
    	   
    	m.addAttribute("username",user.getUser().getUserName());
    	m.addAttribute("colaborateProjects", user.getColaborateProjects());
    	m.addAttribute("otherProjects", user.getOtherProjects());
    	m.addAttribute("movements", user.getUserMovements());
    	m.addAttribute("User", user.getUser());
		return "users";			
    		
    	}
    
    @RequestMapping ("/login")
    	public String login(Model m){
    	return "login";
    }
    
    
}