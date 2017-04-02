/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.noticias;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    //private MultipartFile ruta_imagen;
    private String cuerpo;
    private String categoria;
    private int number_comments;
    //private ArrayList<Long> comentarios;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
   
    public Noticia() {
    }

    public Noticia(String title, /*MultipartFile ruta_imagen,*/ String cuerpo, String categoria, ArrayList<Long> comentarios, Date date) {
        this.title = title;
        this.cuerpo = cuerpo;
        this.categoria = categoria;
        this.date = date;
        number_comments = 0;
        //this.comentarios = comentarios;
        //this.ruta_imagen=ruta_imagen;
    }

    public Noticia(String title, /*MultipartFile ruta_imagen,*/ String cuerpo, int ncom, String categoria, ArrayList<Long> comentarios, Date date) {
        this.title = title;
        this.cuerpo = cuerpo;
        this.categoria = categoria;
        this.date = date;
        this.number_comments = ncom;
        //this.comentarios = comentarios;
        //this.ruta_imagen=ruta_imagen;
    }

    public long getId() {
        return id;
    }

    public String gettitle() {
        return this.title;
    }

    /*public MultipartFile getRutaImagen() {
     return this.ruta_imagen;
     }*/
    public String getCuerpo() {
        return this.cuerpo;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public Date getdate() {
        return this.date;
    }

    public int getNumComentarios() {
        return this.number_comments;
    }

    /*public ArrayList<Long> getComentarios() {
        return this.comentarios;
    }*/

    public void settitle(String title) {
        this.title = title;
    }

   
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /*public void insertarComentario(String comentario) {
        comentarios.add(comentario);
        number_comments++;
    }*/

    /*public void setComentarios(ArrayList<Long> comentarios) {
        this.comentarios = comentarios;
    }*/
    
    public void setNumber_comments(int number_comments) {
        this.number_comments = number_comments;
    }

    public void setdate(Date date) {
        this.date = date;
    }

    public void setId(long id) {
        this.id = id;
    }

}
