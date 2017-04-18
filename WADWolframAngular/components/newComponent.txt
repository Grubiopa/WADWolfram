import { Component } from '@angular/core';
@Component({
selector: 'new',
templateUrl: './new.html'
})
export class NewComponent {
   new: New;

   constructor(private router: Router, private activatedRoute: ActivatedRoute, private service: NewService) {
      let id = activatedRoute.snapshot.params['id'];
      service.getNew(id).subscribe(
         new => this.new = new,
         error => console.error(error)
      );
   }
}
