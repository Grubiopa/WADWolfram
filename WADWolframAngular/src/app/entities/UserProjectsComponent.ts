import { Component } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { Http } from '@angular/http';

@Component({

  selector: 'app-root',

  templateUrl: './UserProjects.component.html',

  styleUrls: ['../app.component.css']

})


export class UserProjectComponent{
 private projectId:number;
    private title:string;
    private shortDescription:string;
    private money:number;

   /* constructor(id:number,title:string,shortDescription:string,money:number){
        this.projectId=id;
        this.title=title;
        this.shortDescription=shortDescription;
        this.money=money;
    }*/
    constructor(){}
    getProjectId(){
        return this.projectId;
    }
    getTitle(){
        return this.title;
    }
    getShortDescription(){
        return this.shortDescription;
    }
    getMoney(){
        return this.money;
    }
      
}