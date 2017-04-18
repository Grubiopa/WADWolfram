import { Component } from '@angular/core';
@Component({
selector: 'project',
templateUrl: './project.html'
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
