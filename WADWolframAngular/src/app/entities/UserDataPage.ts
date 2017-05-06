import { Component, OnInit } from '@angular/core';
import  {  Router,  ActivatedRoute  }  from  '@angular/router';
import {Http} from '@angular/http';
import { UserService } from '../services/UserService';
import {UserPersonalData} from './UserPersonalData';

@Component({

  selector: 'app-root',
  templateUrl: './userDataPage.component.html',
  styleUrls: ['../app.component.css'],
})

export class UserDataPageComponent {

  user: UserPersonalData = {
   userName:"Cargando",
   email:"a@a.es",
   lastname:"rubio",
   name:"gabi",
   passwordHash:"jjj",
   roles:['ROLE_ADMIN']
  };

  changes:boolean = false;
  
  constructor(private router:Router, private users: UserService, private activatedRoute: ActivatedRoute, private http: Http) {
    this.getUser();
  }
  
  getUser(){
    this.user = this.users.getPersonalData()
  }

  getUser2(){
    /* this.users.getPersonalData().subscribe(
      response=>this.user = response,
      error => console.log(error)
    )*/
  }
}