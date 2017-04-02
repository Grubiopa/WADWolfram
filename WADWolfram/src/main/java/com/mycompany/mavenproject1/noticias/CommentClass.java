/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.noticias;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.mycompany.mavenproject1.project.Project;
import com.mycompany.mavenproject1.user.UserPersonalData;

/**
 *
 * @author JuanAntonio
 */
@Entity
public class CommentClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String comentario;
	@ManyToOne
    private UserPersonalData user;
    @ManyToOne
    private Noticia noticia;
    
    public CommentClass() {
    }

    public CommentClass(String comentario, UserPersonalData user, Noticia noticia) {
		this.comentario = comentario;
		this.user = user;
		this.noticia = noticia;
	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public UserPersonalData getUser() {
		return user;
	}



	public void setUser(UserPersonalData user) {
		this.user = user;
	}



	public Noticia getNoticia() {
		return noticia;
	}



	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}



	public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

  
    
    
}
