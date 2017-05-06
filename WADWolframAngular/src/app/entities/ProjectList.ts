import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project } from '../Class/Project';
import { ProjectService } from '../services/ProjectService';

@Component({
   selector: 'projects',
   templateUrl: './projectsList.html',
   styleUrls: ['../app.component.css']
})

export class ProjectListComponent {

    
   projects: Project[];

  constructor(private ps: ProjectService){
    this.projects = new Array();
    this.cogerProyectos();
  }

  cogerProyectos(){
    return this.ps.getProjects().subscribe(
      response=>this.projects = response,
      error => console.log(error)
      );
  }
}