package com.mycompany.mavenproject1.noticias;

public class Comentario {
private String message;

public Comentario(String message){
	this.message=message;
}

public String getMessage(){
	return message;
}

public void setMessage(String m){
	message=m;
}
}
