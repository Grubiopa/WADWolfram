import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {ProjectService} from '../../../services/ProjectService';
import {Project} from '../../../Class/Project';

@Component({
  selector: 'app-root',
  templateUrl: './addproject.component.html',
  styleUrls: ['../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap-theme.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap-theme.min.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap.min.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.eot',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.svg',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.ttf',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.woff',
    '../../../../assets/Bootstrap-Admin-Theme/css/buttons.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/calendar.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/forms.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/stats.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/styles.css'] 
  
})

export class AddProjectComponent{ 
    projects: Project[];

    constructor(private router: Router, private ps: ProjectService){
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
  borrarProyecto(id:number){
    return this.ps.deleteProject(id).subscribe(
      response=>{
          this.router.navigate(['/admin']);
      },
      error => console.log(error)
      );
  }


  newProject(title:string, releaseDate:Date, totalBudget:number, parcialBudget:number,
	time:number, startYear:number,imagen:string, shortDescription:string,  description:string, opened:boolean){
      let project: Project ={
        title:title,
        shortDescription:shortDescription,
        description:description,
        totalBudget:totalBudget,
        parcialBudget:parcialBudget,
        restBudget:0,
        time:time,
        opened:opened,
        releaseDate:releaseDate,
        startYear:startYear,
        imagen:imagen
      }
      this.ps.createProject(project).subscribe(
        project=>{
          this.router.navigate(['/admin']);
        }        
      );
    
  }

}