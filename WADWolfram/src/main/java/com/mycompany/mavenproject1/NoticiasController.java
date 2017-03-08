/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoticiasController {

    @Autowired
    public NoticiasRepository noticias;
    
    @PostConstruct
    public void init() {
		Date releaseDate = new Date();
		ArrayList coments = new ArrayList<>();
		noticias.save(new  Noticia("Noticia1", "i.jpg", "cuerpo", Categoria.ENFERMEDAD, coments, releaseDate));
		noticias.save(new  Noticia("Noticia2", "i.jpg", "cuerpo2", Categoria.ASOCIACION, coments, releaseDate));
	}
    @RequestMapping(value = "/mostrarPorCategoria", method = RequestMethod.GET)
    public String mostrarPorCategoria(Model model, @RequestParam Categoria categoria) {
        ArrayList<Noticia> l = noticias.findByCategoria(categoria);
        model.addAttribute("categoria",categoria);
        model.addAttribute("news", l);
        return "blog_template";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String mostrarTodas(Model model) {
        ArrayList<Noticia> l = noticias.findAll();
        model.addAttribute("news", l);
        return "blog_template";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String mostrarUna(Model model, @RequestParam long id) {
        Noticia n = noticias.findOne(id);
        model.addAttribute("new", n);
        return "new_template";
    }


    @RequestMapping(value="/admin/AddBlog/create", method=RequestMethod.POST)  //URL y method post necesarios.
	public String addNewBlog(@RequestParam String title,@RequestParam String categoria,
                @RequestParam String fecha,@RequestParam String imagen,     //@RP String hola, significa que en el form hay un input con name="hola"
                @RequestParam String cuerpo, @RequestParam Boolean confirm){ ///Se le pasa como parámetros todos los input del form
		
		Date date= new Date();  //Simulamos la hora actual
		Noticia n= new Noticia(title, imagen, cuerpo, Categoria.PROYECTOS, null, date); //Creamos una noticia con todos los datos.
		noticias.save(n);                                                               //Añadimos la noticia a la bbdd
                
                return "Bootstrap-Admin-Theme/index";           //WE ARE OUT!
		
	}

}
