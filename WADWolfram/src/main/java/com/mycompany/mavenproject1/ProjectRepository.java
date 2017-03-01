package com.mycompany.mavenproject1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>{
    
    public Project findByTitle(String ttitle);

	public Project findById(int id);

}