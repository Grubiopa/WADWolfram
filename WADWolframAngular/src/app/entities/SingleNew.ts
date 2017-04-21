import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { NewService } from '../services/NewService';

import { New } from '../Class/New';

import { Http } from '@angular/http';

@Component({

  selector: 'app-root',

  templateUrl: './singleNew.component.html',

  styleUrls: ['../app.component.css'],

})


export class SingleNewComponent{
  new: New;

    constructor(private router: Router, private activatedRoute: ActivatedRoute, private service: NewService) {
  /*   let id = activatedRoute.snapshot.params['id'];
        service.getNew(id).subscribe(
         new => {
          this.new = new;
           console.log(this.new);
          }
        );*/
   }
      
}