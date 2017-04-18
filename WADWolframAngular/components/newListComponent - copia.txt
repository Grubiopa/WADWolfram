import { Component } from '@angular/core';
@Component({
selector: 'news',
templateUrl: './newsList.html'
})
export class NextListComponent {
   news: New[] = [];
   constructor(service: NewService){
      service.getNews(id).subscribe(
         news => this.news = news,
         error => console.error(error)
      );
   }
}