import { Component} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NewService } from '../services/NewService';
import { New } from '../Class/New';

@Component({
  selector: 'new',
  templateUrl: './singleNew.html',
  styleUrls: ['../app.component.css']
})

export class SingleNewComponent{
  nnew: New;

    constructor(private _router: Router, private activatedRoute: ActivatedRoute, private service: NewService) {
          let id = activatedRoute.snapshot.params['id'];
        this.service.getNew(id).subscribe(
         nnew => this.nnew = nnew,
          error => console.error(error)
        );
   }
}