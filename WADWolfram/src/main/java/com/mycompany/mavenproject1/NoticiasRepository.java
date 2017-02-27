/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiasRepository extends JpaRepository<Noticia, Long>{
public ArrayList<Noticia> findByCategoria(Categoria categoria);
public Noticia findByTitulo(String titulo);
}
