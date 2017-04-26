import { Component, OnInit } from '@angular/core';
import { Project } from '../Class/Project';
import { ProjectService } from '../services/ProjectService';

@Component({
   selector: 'projects',
   templateUrl: './projectsList.html',
   styleUrls: ['../app.component.css']
})

export class ProjectListComponent {
   projects: Project[] = [];

   constructor(private service: ProjectService ){
      this.projects=[];
//   ngOnInit(){
      service.getProjects().subscribe(
         projects => this.projects = projects,
         error => console.log(error)
      );
//   }
   }
}