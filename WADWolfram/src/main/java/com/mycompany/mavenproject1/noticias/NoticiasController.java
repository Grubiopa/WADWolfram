package com.mycompany.mavenproject1.noticias;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
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

import com.mycompany.mavenproject1.user.User;

@Controller
public class NoticiasController {

    @Autowired
    public NoticiasRepository noticias;

    private static final String FILES_FOLDER = "fileFolderNews";

    @RequestMapping(value = "/mostrarPorCategoria", method = RequestMethod.GET)
    public String mostrarPorCategoria(Model model, @RequestParam String categoria) {
        ArrayList<Noticia> l = noticias.findByCategoria(categoria);
        //  model.addAttribute("categoria", categoria);
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
    public String mostrarUna(Model model, HttpSession sesion, @RequestParam long id) {
        Noticia n = noticias.findOne(id);
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

    @RequestMapping(value = "/comment/upload/{id}", method = RequestMethod.POST) //put???
    public String Comentar(Model model, HttpSession sesion, @RequestParam String comentarios, @PathVariable long id,
    		HttpServletRequest request) {//pillamos id y el comentario
        Noticia n = noticias.findOne(id);    //pillamos la noticia de la bd
      
        ////CAMBIOS GABI
        User s = (User) sesion.getAttribute("User");
        
        if (!(request.isUserInRole("USER")||request.isUserInRole("ADMIN"))) {
            return "login";
        } else {
            String nombre = s.getUser().getName();
            nombre = nombre + " dice: \n" + comentarios + "\n";
            n.getComentarios().add(new CommentClass(nombre,comentarios));

            n.setNumber_comments(n.getNumComentarios() + 1);
            noticias.save(n);
            //n2.Comentar(comentarios, id);

            model.addAttribute("new", n);
            model.addAttribute("lcomentarios", n.getComentarios());
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
        ArrayList<CommentClass> x = new ArrayList<>();
        Noticia n = new Noticia(title, /*imagen,*/ cuerpo, categoria, x, date); //Creamos una noticia con todos los datos.

        noticias.save(n);                                                               //Añadimos la noticia a la bbdd

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
        Noticia n = noticias.findOne(id);
        noticias.delete(n);
        User u = (User) sesion.getAttribute("User");
        m.addAttribute("bienvenido",u.getUser().getUserName());
        return "Bootstrap-Admin-Theme/index";
    }
}