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
public class Noticia{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String titulo;
private String ruta_imagen;
private String cuerpo;
private Categoria categoria;
private int num_comentarios;
private ArrayList<String> comentarios;
private Date fecha;

//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//Date d = sdf.parse("21/12/2012");

public Noticia(String titulo, String ruta_imagen, String cuerpo, Categoria categoria, Date fecha){
this.titulo=titulo;
this.cuerpo=cuerpo;
this.categoria=categoria;
this.fecha=fecha;
num_comentarios=0;
this.comentarios=new ArrayList<>();
}

public long getId(){
return id;
}

public String getTitulo(){
return this.titulo;
}

public String getRutaImagen(){
return this.ruta_imagen;
}

public String getCuerpo(){
return this.cuerpo;
}

public Categoria getCategoria(){
return this.categoria;
}

public Date getFecha(){
return this.fecha;
}

public int getNumComentarios(){
return this.num_comentarios;
}

public ArrayList<String> getComentarios(){
return this.comentarios;
}

public void setTitulo(String titulo){
this.titulo=titulo;
}

public void setRutaImagen(String ruta_imagen){
this.ruta_imagen=ruta_imagen;
}

public void setCuerpo(String cuerpo){
this.cuerpo=cuerpo;
}

public void setCategoria(Categoria categoria){
this.categoria=categoria;
}

public void insertarComentario(String comentario){
comentarios.add(comentario);
num_comentarios++;
}


public void setFecha(Date fecha){
this.fecha=fecha;
}

}
