/*
 * To change this license header, choose License Headers in UserProject Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author TOSHIBA
 */
@Controller
public class IndexController {
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
    
}
