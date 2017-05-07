import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {NewService} from '../../../services/NewService';
import {New} from '../../../Class/New';

@Component({
  selector: 'app-root',
  templateUrl: './addblog.component.html',
  styleUrls: ['../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap-theme.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap-theme.min.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap.min.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.eot',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.svg',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.ttf',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.woff',
    '../../../../assets/Bootstrap-Admin-Theme/css/buttons.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/calendar.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/forms.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/stats.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/styles.css'] 
})

export class AddBlogComponent{ 
   news: New[];

    constructor(private router: Router, private ns: NewService){
     this.news = new Array();
    this.cogerNews();
  }

  cogerNews(){
    return this.ns.getNews().subscribe(
      response=>{
        console.log(response),
        this.news = response,
        console.log(this.news)
      },
      error => console.log(error)
      );
  }
  borrarNew(id:number){
    return this.ns.deleteNew(id).subscribe(
      response=>{
          this.router.navigate(['/admin']);
      },
      error => console.log(error)
      );
  }


  newNew(title:string, categoria:string, fecha:Date, imagen:string,  cuerpo:string, confirm:boolean){
      let nnew: New ={
        title:title,
        body:cuerpo,
        category:categoria,
        number_comments:0,
        date:fecha
      }
      this.ns.createNew(nnew).subscribe(
        nnew=>{
          this.router.navigate(['/admin']);
        }        
      );
    
  }
}