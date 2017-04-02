package com.mycompany.mavenproject1.noticias;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.mavenproject1.noticias.CommentClass;
import com.mycompany.mavenproject1.noticias.NoticiasService;
import com.mycompany.mavenproject1.noticias.Noticia;
import com.mycompany.mavenproject1.user.User;

@Controller
public class NoticiasController {

    @Autowired
    private NoticiasService service;
    
    @Autowired
    private CommentClassRepository coments;
    
    private static final String FILES_FOLDER = "fileFolderNews";

    @RequestMapping(value = "/mostrarPorCategoria", method = RequestMethod.GET)
    public String mostrarPorCategoria(Model model, @RequestParam String categoria) {
        ArrayList<Noticia> l = service.mostrarPorCategoria(categoria);
  
        model.addAttribute("news", l);
        return "blog_template";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String mostrarTodas(Model model) {
        ArrayList<Noticia> l = service.mostrarTodas();
        model.addAttribute("news", l);
        return "blog_template";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String mostrarUna(Model model, HttpSession sesion, @RequestParam long id) {
        Noticia n = service.mostrarUna(id);
        User s = (User) sesion.getAttribute("User");
        model.addAttribute("new", n);
        model.addAttribute("lcomentarios", n.getComentarios());
        model.addAttribute("id", n.getId());
        if(s==null){
            model.addAttribute("logeado", true);
        }else{
            model.addAttribute("logeado2", true);
        }
        return "new_template";
    }

    @RequestMapping(value = "/comment/upload/{id}", method = RequestMethod.POST) 
    public String Comentar(Model model, HttpSession sesion, @RequestParam String comentarios, @PathVariable long id) {//pillamos id y el comentario
        User s = (User) sesion.getAttribute("User");
        if (s == null) {
            return "login";
        } 
        else {
        	Noticia n=service.comentar(s, comentarios, id);
            model.addAttribute("new", n);
            List<String> lcomentsShow = new ArrayList<>();
            List<CommentClass> lcoments = coments.findByNoticia(n);
            for(CommentClass com: lcoments){
            	lcomentsShow.add(com.getUser().getUserName() + " dice: " + com.getComentario());
            }
            model.addAttribute("lcomentarios", lcomentsShow);
            model.addAttribute("id", n.getId());
            model.addAttribute("logeado2", true);
            
            return "new_template";
        }
    }

    @RequestMapping(value = "/admin/AddBlog/create", method = RequestMethod.POST)  //URL y method post necesarios.
    public String addNewBlog(Model model, HttpSession sesion,@RequestParam String title, @RequestParam String categoria,
            @RequestParam String fecha, @RequestParam("imagen") MultipartFile imagen, //@RP String hola, significa que en el form hay un input con name="hola"
            @RequestParam String cuerpo, @RequestParam Boolean confirm) { ///Se le pasa como parámetros todos los input del form

        Date date = new Date();  //Simulamos la hora actual
        ArrayList<Long> x = new ArrayList<>();
        Noticia n = new Noticia(title,/*imagen,*/ cuerpo, categoria, x, date); //Creamos una noticia con todos los datos.

        n=service.addNewBlog(n);

        String fileName = n.getId() + ".jpg";
        if (!imagen.isEmpty()) {
            try {

                File filesFolder = new File(FILES_FOLDER);
                if (!filesFolder.exists()) {
                    filesFolder.mkdirs();
                }

                File uploadedFile = new File(filesFolder.getAbsolutePath(), fileName);
                imagen.transferTo(uploadedFile);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        User u = (User) sesion.getAttribute("User");
        model.addAttribute("bienvenido",u.getUser().getUserName());
        return "Bootstrap-Admin-Theme/index";           //WE ARE OUT!

    }

    @RequestMapping("/image/{fileName}.jpg")
    public void handleFileDownload(@PathVariable String fileName,
            HttpServletResponse res) throws FileNotFoundException, IOException {

        File file = new File(FILES_FOLDER, fileName + ".jpg");

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

    @RequestMapping(value = "/borrarNoticia", method = RequestMethod.POST)
    public String deleteProject(@RequestParam long id, Model m, HttpSession sesion) {
        service.deleteNew(id);
        User u = (User) sesion.getAttribute("User");
        m.addAttribute("bienvenido",u.getUser().getUserName());
        return "Bootstrap-Admin-Theme/index";
    }
}
