import { Component, OnInit } from '@angular/core';
import { New } from '../Class/New';
import { NewService } from '../services/NewService';

@Component({
  selector: 'blog',
  templateUrl: './blog.html',
  styleUrls: ['../app.component.css']
})

export class BlogComponent /*implements OnInit*/{
   news: New[] = [];
   constructor(private service: NewService){
//    ngOnInit() {
      this.service.getNews().subscribe(
         news => this.news = news,
         error => console.log(error)
      ); 
//   } 
   }
}