package com.mycompany.mavenproject1.noticias;

import java.util.List;

public class NoticiaView {

	private Noticia noticia;
	private List<String> coments;
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	public List<String> getComents() {
		return coments;
	}
	public void setComents(List<String> coments) {
		this.coments = coments;
	}
	public NoticiaView(Noticia noticia, List<String> coments) {
		super();
		this.noticia = noticia;
		this.coments = coments;
	}
	
	public NoticiaView(){}
}
