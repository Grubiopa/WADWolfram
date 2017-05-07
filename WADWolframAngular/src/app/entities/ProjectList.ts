import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { Project } from '../Class/Project';
import { ProjectService } from '../services/ProjectService';
import { Http } from '@angular/http';

@Component({
   selector: 'projects',
   templateUrl: './projectsList.html',
   styleUrls: ['../app.component.css']
})

export class ProjectListComponent {

    
   projects: Project[];

  constructor(private ps: ProjectService, private router:Router, private activatedRoute: ActivatedRoute, private http: Http ){
    this.projects = new Array();
    this.cogerProyectos();
  }

  cogerProyectos(){
    return this.ps.getProjects().subscribe(
      response=>{
        console.log(response),
        this.projects = response,
        console.log(this.projects)
      },
      error => console.log(error)
      );
  }
}