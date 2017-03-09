/*
 * To change this license header, choose License Headers in UserProject Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author TOSHIBA
 */
@Controller
public class IndexController {
	
	@Autowired
    public UserPersonalDataRepository anotheruser;
	
	
    @RequestMapping ("/")
    public String ShowIndex(Model m){
    return "index_template";
    }
    
   /*@RequestMapping ("/projects")
    public String ShowProjects(Model m){
    return "projects_template";
    }
    @RequestMapping ("/blog")
    public String ShowBlog(Model m){
    return "blog_template";
    }*/
    @RequestMapping ("/contact")
    public String ShowContact(Model m){
    return "contact";
    }
    @RequestMapping ("/about")
    public String ShowAbout(Model m){
    return "about";
    }
    @RequestMapping ("/register")
    public String ShowRegister(Model m){
    return "register";
    }
    
    @RequestMapping (value="/register/create", method=RequestMethod.POST)
    public String NewUser(Model model,@RequestParam String aname,@RequestParam String lastName,@RequestParam String username,@RequestParam String aemail,
            @RequestParam String apass,@RequestParam String apass2){
        ArrayList<Role> rol= new ArrayList<>();
        UserPersonalData u = new UserPersonalData(aname,lastName,username,aemail,apass, apass2, "i.jpg", rol);
        anotheruser.save(u); 
    //    model.addAttribute("username",username);
    return "index_template";
    }
   
    
}
