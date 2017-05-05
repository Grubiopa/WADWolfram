import { Component, OnInit } from '@angular/core';
import { Project } from '../Class/Project';
import { ProjectService } from '../services/ProjectService';
import { New } from '../Class/New';
import { NewService } from '../services/NewService';
import { ProjectProgress } from '../Class/ProjectProgress';

@Component({
  selector: 'index',
  templateUrl: './index.html',
  styleUrls: ['../app.component.css']
})

export class IndexComponent implements OnInit {
  projects: Project[] = [];
  news: New[] = [];
  projectsProgress: ProjectProgress[] = [];

   constructor(private projectService: ProjectService, private newService: NewService){}
   ngOnInit(){
      this.projectService.getProjects().subscribe(
         projects => this.projects = projects,
         error => console.log(error)
      );
      this.newService.getNews().subscribe(
         news => this.news = news,
         error => console.log(error)
      );
      for(let project of this.projects){
         let p: ProjectProgress = new ProjectProgress(project.title, (project.parcialBudget*100/project.totalBudget));
         this.projectsProgress.push(p);         
      }
   }
}