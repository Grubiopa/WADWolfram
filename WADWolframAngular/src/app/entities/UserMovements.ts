import { Component } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { Http } from '@angular/http';

@Component({

  selector: 'app-root',

  templateUrl: './UserMovements.component.html',

  styleUrls: ['../app.component.css']

})


export class UserMovementsComponent{
    private projectTitle:string;
	private money:number;
    private date:Date;

   /* constructor(title:string,money:number,date:Date){
        this.projectTitle=title;
        this.money=money;
        this.date=date;
    }*/
    constructor(){}
    getProjectTitle(){
        return this.projectTitle;
    }
    getMoney(){
        return this.money;
    }
    getDate(){
        return this.date;
    }
}