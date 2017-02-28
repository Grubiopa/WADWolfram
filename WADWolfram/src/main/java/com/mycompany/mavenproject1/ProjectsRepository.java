package com.mycompany.mavenproject1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Project, Long> {

	

}
