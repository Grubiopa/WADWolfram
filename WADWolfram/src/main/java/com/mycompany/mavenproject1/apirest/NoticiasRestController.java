package com.mycompany.mavenproject1.apirest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.mavenproject1.noticias.Comentario;
import com.mycompany.mavenproject1.noticias.Noticia;
import com.mycompany.mavenproject1.noticias.NoticiaView;
import com.mycompany.mavenproject1.noticias.NoticiasService;
import com.mycompany.mavenproject1.user.User;

@RestController

@RequestMapping(value="/api")
public class NoticiasRestController {

    @Autowired
    private NoticiasService service;

  //  private static final String FILES_FOLDER = "fileFolderNews";

    @RequestMapping(value = "/mostrarPorCategoria/{categoria}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Noticia>> mostrarPorCategoria(@PathVariable String categoria) {
        ArrayList<Noticia> l = service.mostrarPorCategoria(categoria);
        if (!l.isEmpty())  
           return new ResponseEntity<>(l, HttpStatus.OK);
        else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public ArrayList<Noticia> mostrarTodas(	) {
        return service.mostrarTodas();
    }

    @RequestMapping(value = "/new/{id}", method = RequestMethod.GET)
    public ResponseEntity<NoticiaView> mostrarUna(@PathVariable long id) {
        NoticiaView n = service.mostrarUna(id);
        if (n!=null)
           	return new ResponseEntity<>(n, HttpStatus.OK);
        else
           	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/comment/upload/{id}", method = RequestMethod.PUT)
    public ResponseEntity<NoticiaView> comentar(HttpSession sesion, @RequestBody Comentario comentarios, @PathVariable long id) {
        User s = (User) sesion.getAttribute("User");
        if (s == null) {
        	//revisar
           	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
        else {
        	   NoticiaView n=service.comentar(s, comentarios.getTexto(), id);
        	   if(n!=null)
           		   return new ResponseEntity<>(n, HttpStatus.OK);
        		   else
           			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = 		"/admin/AddBlog/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Noticia addNewBlog(				@RequestBody Noticia  noticia){
        Noticia n=service.addNewBlog(noticia);
        /*
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
  */
       return n;
    }
    
/*
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
*/
    
    @RequestMapping(value = "/borrarNoticia/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Noticia> deleteProject(@PathVariable long id, HttpSession sesion) {
        Noticia n=service.deleteNew(id);
        if(n!=null)
           	return new ResponseEntity<>(n, HttpStatus.OK);
        else
           	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
}
