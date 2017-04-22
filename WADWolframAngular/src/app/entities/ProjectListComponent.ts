import { Component } from '@angular/core';
import{Project} from '../Class/Project'
import{ProjectService} from '../services/ProjectService'
@Component({
selector: 'app-root',
templateUrl: './projectsList.html'
})
export class ProjectListComponent {
   projects: Project[] = [];
   constructor(service: ProjectService){
    /*  service.getProject(id).subscribe(
         projects => this.projects = projects,
         error => console.error(error)
      );*/
   }
}