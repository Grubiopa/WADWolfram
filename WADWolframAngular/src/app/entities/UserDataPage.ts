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
   passwordHash:"jjj"
  };

  changes:boolean = false;
  
  constructor(private router:Router, private users: UserService, private activatedRoute: ActivatedRoute, private http: Http) {
    this.getUser2();
  }
  
  getUser(id:number){
    this.http.get('http://localhost:8443/api/user/personalData').subscribe(
      response=>this.user = response.json(),
      error => console.log(error)
    )
  }

  getUser2(){
    this.users.getUser().subscribe(
      response=>this.user = response,
      error => console.log(error)
    )
  }
}