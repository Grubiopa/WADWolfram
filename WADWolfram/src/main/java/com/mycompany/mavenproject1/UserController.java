package com.mycompany.mavenproject1;
import java.util.ArrayList;

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
    User user = new User(new ArrayList<UserProject>(), new ArrayList<UserProject>(),new ArrayList<UserMovements>(), new UserPersonalData("Gabi", "Rubio", "y@gmail.com", "gabi0794", "1234", "Nueva contraseña", "icon.png"));
    
    
    m.addAttribute("username", user.getUser().getName());
    m.addAttribute("colaborateProjects", user.getColaborateProjects());
    m.addAttribute("otherProjects", user.getOtherProjects());
    m.addAttribute("movements", user.getUserMovements());
    m.addAttribute("User", user.getUser());
    
    return "users";
    }
    
    
}