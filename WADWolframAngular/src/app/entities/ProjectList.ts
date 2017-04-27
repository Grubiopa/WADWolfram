import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project } from '../Class/Project';
import { ProjectService } from '../services/ProjectService';

@Component({
   selector: 'projects',
   templateUrl: './projectsList.html',
   styleUrls: ['../app.component.css']
})

export class ProjectListComponent implements OnInit {

    
   projects: Project[] = [];

   constructor(private router: Router, private service: ProjectService){}
   ngOnInit(){
      this.service.getProjects().subscribe(
         projects => this.projects = projects,
         error => console.log(error)
      );
   }
}