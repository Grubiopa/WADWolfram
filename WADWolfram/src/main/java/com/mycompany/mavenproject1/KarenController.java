/*
 * To change this license header, choose License Headers in Project Properties.
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
    return "oneProject";
    }
}
