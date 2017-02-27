package com.mycompany.mavenproject1;

import java.util.List;

public interface NewsRepository extends JpaRepository<Noticia, long>{
public List<New> findByCategory(Category categoriy);
public New findByTitle(String title);
}