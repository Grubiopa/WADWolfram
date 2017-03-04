/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JuanAntonio
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @RequestMapping("/Index")
    public String index(Model m){
        return "Bootstrap-Admin-Theme/index";
    }
    
    
    @RequestMapping("/AddBlog")
    public String addblog(Model m){
        return "Bootstrap-Admin-Theme/addblog";
    }
    
    
    
    @RequestMapping("/AddProject")
    public String addproject(Model m){
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
    
    
    
}
