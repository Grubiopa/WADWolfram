/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Date;
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

    @RequestMapping(value = "/mostrarPorCategoria", method = RequestMethod.GET)
    public String mostrarPorCategoria(Model model, @RequestParam Categoria categoria) {
        ArrayList<Noticia> l = noticias.findByCategoria(categoria);
        model.addAttribute("categoria", l);
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


    @RequestMapping(value = "/loadNew", method = RequestMethod.POST)
    public void cargarNoticia(@RequestParam String titulo,@RequestParam String ruta_imagen,
            @RequestParam String cuerpo,@RequestParam Categoria categoria,@RequestParam ArrayList comentarios, @RequestParam Date fecha){
        Noticia n = new Noticia(titulo, ruta_imagen, cuerpo, categoria, comentarios, fecha);
        noticias.save(n);
    }

}
