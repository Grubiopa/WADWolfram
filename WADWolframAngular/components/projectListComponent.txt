import { Component } from '@angular/core';
@Component({
selector: 'projects',
templateUrl: './projectsList.html'
})
export class ProjectsListComponent {
   projects: Project[] = [];
   constructor(service: ProjectService){
      service.getProjects(id).subscribe(
         projects => this.projects = projects,
         error => console.error(error)
      );
   }
}