package com.mycompany.mavenproject1.noticias;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentClassRepository extends JpaRepository<CommentClass, Long> {
   
	List<CommentClass> findByNoticia(Noticia n);
}