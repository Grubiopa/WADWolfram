package com.mycompany.mavenproject1;

public interface ProjectsRepository extends JpaRepository<Proyecto, long>{
public Project findByTitle(String ttitle);
}