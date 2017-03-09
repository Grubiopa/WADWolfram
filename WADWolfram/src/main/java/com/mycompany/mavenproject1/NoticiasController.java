/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NoticiasController {

    @Autowired
    public NoticiasRepository noticias;
    
    private static final String FILES_FOLDER = "files";
    
    @PostConstruct
    public void init() {
		Date releaseDate = new Date();
		ArrayList coments = new ArrayList<>();
		MultipartFile a = null;
		noticias.save(new  Noticia("Noticia1", a, "cuerpo", "enfermedad", coments, releaseDate));
		MultipartFile b=null;
		noticias.save(new  Noticia("Noticia2", b, "cuerpo2", "eventos", coments, releaseDate));
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
	public String addNewBlog(Model model,@RequestParam String title,@RequestParam String categoria,
                @RequestParam String fecha,@RequestParam ("imagen") MultipartFile imagen,     //@RP String hola, significa que en el form hay un input con name="hola"
                @RequestParam String cuerpo, @RequestParam Boolean confirm){ ///Se le pasa como parámetros todos los input del form
    	
		Date date= new Date();  //Simulamos la hora actual
		Noticia n= new Noticia(title, imagen, cuerpo, categoria, null, date); //Creamos una noticia con todos los datos.
		
		noticias.save(n);                                                               //Añadimos la noticia a la bbdd
                
		String fileName = n.getId() + ".jpg";
		File filesFolder = new File(FILES_FOLDER);
		File uploadedFile = new File(filesFolder.getAbsolutePath(), fileName);
		try {
			imagen.transferTo(uploadedFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return "Bootstrap-Admin-Theme/index";           //WE ARE OUT!
		
	}

    
    @RequestMapping("/image/{fileName}.jpg")
	public void handleFileDownload(@PathVariable String fileName,
			HttpServletResponse res) throws FileNotFoundException, IOException {

		File file = new File(FILES_FOLDER, fileName+".jpg");

		if (file.exists()) {
			res.setContentType("image/jpeg");
			res.setContentLength(new Long(file.length()).intValue());
			FileCopyUtils
					.copy(new FileInputStream(file), res.getOutputStream());
		} else {
			res.sendError(404, "File" + fileName + "(" + file.getAbsolutePath()
					+ ") does not exist");
		}
	}
}
