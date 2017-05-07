package com.mycompany.mavenproject1.noticias;

import java.util.Date;
import java.util.List;
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

    public NoticiaView mostrarUna(long id) {
        Noticia n = noticias.findOne(id);
        NoticiaView nv;
    	List<String> lcomentsShow = new ArrayList<>();
        List<CommentClass> lcoments = coments.findByNoticia(n);
        for(CommentClass com: lcoments){
        	lcomentsShow.add(com.getUser().getUserName() + " dice: " + com.getComentario());
        }
        nv = new NoticiaView(n,lcomentsShow);
        return nv;
    }

    public NoticiaView comentar(User u, String comentario, long id){ 
        Noticia n = noticias.findOne(id);    //pillamos la noticia de la bd
        NoticiaView nv = null;
        if (n!=null){
           CommentClass c = new CommentClass(comentario, u.getUser(),n);
           coments.save(c);
           n.setNumber_comments(n.getNumComentarios() + 1);
           noticias.save(n);
           List<String> lcomentsShow = new ArrayList<>();
           List<CommentClass> lcoments = coments.findByNoticia(n);
           for(CommentClass com: lcoments){
           	lcomentsShow.add(com.getUser().getUserName() + " dice: " + com.getComentario());
           }
           nv = new NoticiaView(n,lcomentsShow);
           }
        return nv;
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
