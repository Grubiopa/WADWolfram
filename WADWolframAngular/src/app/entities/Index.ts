import { Component } from '@angular/core';
import {ProjectService} from '../services/ProjectService';
import {NewService} from '../services/NewService';
import {Project} from '../Class/Project';
import {New} from '../Class/New';


@Component({
  selector: 'index',
  templateUrl: './index.html',
  styleUrls: ['../app.component.css']
})

export class IndexComponent{
  projects: Project[];
  blogs: New[];
  
  constructor(private ps: ProjectService, private bs: NewService){
    this.projects = new Array();
    this.blogs = new Array();
    this.cogerProyectos();
    this.cogerBlogs();
  }

  cogerProyectos(){
    return this.ps.getProjects().subscribe(
      response=>this.projects = response,
      error => console.log(error)
      );
  }

cogerBlogs(){
    return this.bs.getNews().subscribe(
      response=>this.blogs = response,
      error => console.log(error)
      
    );
  }


}