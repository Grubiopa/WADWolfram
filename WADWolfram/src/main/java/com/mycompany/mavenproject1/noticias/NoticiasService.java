package com.mycompany.mavenproject1.noticias;

import java.util.Date;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import com.mycompany.mavenproject1.user.User;
@Service
public class NoticiasService {

    @Autowired
    private NoticiasRepository noticias;
    @Autowired
    private CommentClassRepository coments;

    private static final String FILES_FOLDER = "fileFolderNews";
   
    public  ArrayList mostrarPorCategoria(String categoria) {
        return noticias.findByCategoria(categoria);
    }
        
    public ArrayList<Noticia> mostrarTodas() {
        return noticias.findAll();
    }

    public Noticia mostrarUna(long id) {
        return noticias.findOne(id);
    }

    public Noticia comentar(User u, String comentario, long id){ 
        Noticia n = noticias.findOne(id);    //pillamos la noticia de la bd
        if (n!=null){
           CommentClass c = new CommentClass(comentario, u.getUser(),n);
           coments.save(c);
           n.getComentarios().add(c.getId());
           n.setNumber_comments(n.getNumComentarios() + 1);
           noticias.save(n);
           }
        return n;
   }

    public Noticia addNewBlog(Noticia noticia){
       	noticias.save(noticia);                                                               //Añadimos la noticia a la bbdd
       return noticia;
    }
    
/*
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
    
    public Noticia deleteNew(long id){
        Noticia n = noticias.findOne(id);
        if (n!=null)
           noticias.delete(n);
        return n;
    }
}
