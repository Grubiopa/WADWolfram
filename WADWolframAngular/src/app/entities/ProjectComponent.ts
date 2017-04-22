import { Component } from '@angular/core';
import {Project} from '../Class/Project'
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import {ProjectService} from '../services/ProjectService';

@Component({
selector: 'app-root',
templateUrl: './project.component.html',
})
export class ProjectComponent {
   project: Project;

   constructor(private router: Router, private activatedRoute: ActivatedRoute, private service: ProjectService) {
      let id = activatedRoute.snapshot.params['id'];
      service.getProject(id).subscribe(
         project => this.project = project,
         error => console.error(error)
      );
   }
}
