import { Component } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { Http } from '@angular/http';

import {UserProjects} from '../entities/UserProjects';
import {UserService} from '../services/UserService';
import {LoginService} from '../services/LoginService';

@Component({

  selector: 'app-root',

  templateUrl: './UserProjects.component.html',

  styleUrls: ['../app.component.css']

})


export class UserProjectComponent{
 private projectId:number;
   
        userProjects :UserProjects[];
        otherProjects:UserProjects[];
   /* constructor(id:number,title:string,shortDescription:string,money:number){
        this.projectId=id;
        this.title=title;
        this.shortDescription=shortDescription;
        this.money=money;
    }*/
    constructor(private router:Router, private login:LoginService,private users: UserService, private activatedRoute: ActivatedRoute, private http: Http){
        this.userProjects = new Array();
        this.otherProjects = new Array();
        this.loadProjectsUser();
    }
    loadProjectsUser(){
      return this.users.getUserProjects().subscribe(
      response=>this.userProjects = response,
      error => console.log(error)
      )
        /*let project1:UserProjects={
           money:5000,
           projectTitle: "P1",
           shortDescription: "projecto1"
        }
        let project2:UserProjects={
           money:5000,
           projectTitle: "P2",
           shortDescription: "projecto2"
        }
        let project3:UserProjects={
           money:0,
           projectTitle: "P3",
           shortDescription: "projecto3"
        }
        let project4:UserProjects={
           money:0,
           projectTitle: "P4",
           shortDescription: "projecto4"
        }
        this.userProjects.push(project1);
        this.userProjects.push(project2);
        this.otherProjects.push(project3);
        this.otherProjects.push(project4);*/
    }
    loadOtherProjects(){
      return this.users.getOtherProjects().subscribe(
      response=>this.otherProjects = response,
      error => console.log(error))
    }
      
}