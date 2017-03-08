/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String ruta_imagen;
    private String cuerpo;
    private Categoria categoria;
    private int number_comments;
    private ArrayList<String> comentarios;
    private Date date;

//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//Date d = sdf.parse("21/12/2012");
    public Noticia(){}
    public Noticia(String title, String ruta_imagen, String cuerpo, Categoria categoria, ArrayList comentarios, Date date) {
        this.title = title;
        this.cuerpo = cuerpo;
        this.categoria = categoria;
        this.date = date;
        number_comments = 0;
        this.comentarios = comentarios;
        this.ruta_imagen=ruta_imagen;
    }

    public long getId() {
        return id;
    }

    public String gettitle() {
        return this.title;
    }

    public String getRutaImagen() {
        return this.ruta_imagen;
    }

    public String getCuerpo() {
        return this.cuerpo;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public Date getdate() {
        return this.date;
    }

    public int getNumComentarios() {
        return this.number_comments;
    }

    public ArrayList<String> getComentarios() {
        return this.comentarios;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public void setRutaImagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void insertarComentario(String comentario) {
        comentarios.add(comentario);
        number_comments++;
    }

    public void setdate(Date date) {
        this.date = date;
    }

}
