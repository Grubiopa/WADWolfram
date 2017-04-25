import { Component, OnInit } from '@angular/core';
import { Http } from "@angular/http";
import { Router, ActivatedRoute } from '@angular/router';
import{New} from '../Class/New';
import{NewService} from '../services/NewService';

@Component({

  selector: 'blog',

  templateUrl: './blog.component.html',

  styleUrls: ['../app.component.css']

})

export class BlogComponent /*implements OnInit*/{
   news: New[] = [];
   constructor(private _router: Router, private service: NewService){}
    ngOnInit() {
      this.service.getNews().subscribe(
         news => this.news = news,
         error => console.log(error)
      ); 
    
   }
}
