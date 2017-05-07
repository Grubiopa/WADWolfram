import { Component } from '@angular/core';
import { Project } from '../Class/Project'
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { ProjectService } from '../services/ProjectService';

@Component({
   selector: 'project',
   templateUrl: './project.html',
   styleUrls: ['../app.component.css']
})

export class ProjectComponent {
   project: Project ={
    description:"cargando",
    imagen:"image",
    opened:true,
    parcialBudget:0,
    releaseDate : new Date(),
    restBudget:0,
    shortDescription:"cargando",
    startYear:2017,
    time:0,
    title:"cargando",
    totalBudget:0
    };

    id:number
   constructor(private router: Router, activatedRoute: ActivatedRoute, private service: ProjectService){
     this.id = activatedRoute.snapshot.params['id'];
      this.loadProject(this.id);
   }
 loadProject(id:number){
     console.log(id);
     return this.service.getProject(id).subscribe(
         project => this.project = project,
         error => console.error(error)
      );
 }
 redirigir(){
     this.router.navigate(['/pay',this.id]);
 }
}