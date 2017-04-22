import { Component, OnInit } from '@angular/core';
import { Http } from "@angular/http";
import { Router, ActivatedRoute } from '@angular/router';
import{Project} from '../Class/Project';
import{ProjectService} from '../services/ProjectService';
@Component({
selector: 'app-root',
templateUrl: './projectsList.html',
  styleUrls: ['../app.component.css']

})
export class ProjectListComponent {
   projects: Project[] = [];
   constructor(    private _router: Router, service: ProjectService ){
      /* ngOnInit(){
      service.getProject().subscribe(
         projects => this.projects = projects,
         error => console.log(error)
      );
      }*/
   }
}