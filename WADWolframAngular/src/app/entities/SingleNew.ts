import { Component} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NewService } from '../services/NewService';
import { New } from '../Class/New';
import { Http } from '@angular/http';
@Component({
  selector: 'app-root',
  templateUrl: './singleNew.component.html',
  styleUrls: ['../app.component.css']
})

export class SingleNewComponent{
  nnew: New;

    constructor(private _router: Router, private activatedRoute: ActivatedRoute, private service: NewService) {
          let id = activatedRoute.snapshot.params['id'];

        service.getNew(id).subscribe(
         nnew => this.nnew = nnew,
          error => console.error(error)
        );
   }
      
}