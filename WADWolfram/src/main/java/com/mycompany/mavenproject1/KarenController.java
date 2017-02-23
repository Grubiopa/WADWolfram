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
public class KarenController {
    @RequestMapping ("/karen")
    public String saludo(Model m){
    m.addAttribute("nombre", "tono");
    return "karen";
    }
    
    @RequestMapping ("/prueba")
    public String carga(Model m){
    m.addAttribute("nombre", "tono");
    return "Bootstrap-Admin-Theme/index";
    }
    @RequestMapping ("/prueba1")
    public String carga1(Model m){
    m.addAttribute("nombre", "tono");
    return "Bootstrap-Admin-Theme/addproject";
    }
    @RequestMapping ("/prueba2")
    public String carga2(Model m){
    m.addAttribute("nombre", "tono");
    return "Bootstrap-Admin-Theme/addblog";
    }
    @RequestMapping ("/prueba3")
    public String carga3(Model m){
    m.addAttribute("nombre", "tono");
    return "Bootstrap-Admin-Theme/donations";
    }
    @RequestMapping ("/prueba4")
    public String carga4(Model m){
    m.addAttribute("nombre", "tono");
    return "Bootstrap-Admin-Theme/profile";
    }
}
