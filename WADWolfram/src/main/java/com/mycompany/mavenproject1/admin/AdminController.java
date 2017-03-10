/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.admin;

import com.mycompany.mavenproject1.Noticia;
import com.mycompany.mavenproject1.NoticiasRepository;
import com.mycompany.mavenproject1.Project;
import com.mycompany.mavenproject1.ProjectRepository;
import com.mycompany.mavenproject1.Role;
import com.mycompany.mavenproject1.User;
import com.mycompany.mavenproject1.UserPersonalData;
import com.mycompany.mavenproject1.UserPersonalDataRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JuanAntonio
 */
@Controller
@RequestMapping("/admin")
public class AdminController { 
	

    @Autowired
    public NoticiasRepository noticias;

    @Autowired
    public ProjectRepository projects;

    @Autowired
    public UserPersonalDataRepository adminuser;
    
    @RequestMapping("/Index")
    public String index(Model m){
        return "Bootstrap-Admin-Theme/index";
    }
    
    
    @RequestMapping("/AddBlog")
    public String addblog(Model m){
    	List<Noticia> not= noticias.findAll();
    	m.addAttribute("noticias",not);
        return "Bootstrap-Admin-Theme/addblog";
    }
    
    
    
    @RequestMapping("/AddProject")
    public String addproject(Model m){
		List<Project> proj= projects.findAll();
    	m.addAttribute("projects",proj);
        return "Bootstrap-Admin-Theme/addproject";
    }
    
    
    
    @RequestMapping("/Donations")
    public String donations(Model m){
        return "Bootstrap-Admin-Theme/donations";
    }
    
    
    
    @RequestMapping("/Profile")
    public String profile(Model m){
        return "Bootstrap-Admin-Theme/profile";
    }
    
    @RequestMapping (value="/Profile/create", method=RequestMethod.POST)
    public String NewAdmin(@RequestParam String name,@RequestParam String email,
            @RequestParam String password,@RequestParam String repeat_password,
            @RequestParam Boolean confirm){
        
        ArrayList<String> rol= new ArrayList<>();
        rol.add("ADMIN");
        UserPersonalData u = new UserPersonalData(name, "", email, name, password, repeat_password, "i.jpg", rol);
        adminuser.save(u);
    return "Bootstrap-Admin-Theme/index";
    }
    
    
    @RequestMapping (value="/Profile/update", method = RequestMethod.PUT)
    public String UpdateAdmin(){
    return "Bootstrap-Admin-Theme/index";
    }
    
}
