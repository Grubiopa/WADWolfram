import { Component, OnInit } from '@angular/core';
import  { Router,  ActivatedRoute  }  from  '@angular/router';
import {Http} from '@angular/http';
import { UserService } from '../services/UserService';
import {UserPersonalData} from './UserPersonalData';
import {UserUpdate} from './UserUpdate';
import {LoginService} from '../services/LoginService';
import {ProjectService} from '../services/ProjectService';
import {Donation} from '../Class/Donation';

@Component({

  selector: 'app-root',
  templateUrl: './pay.html',
  styleUrls: ['../app.component.css'],
})

export class PayComponent {

  user: UserPersonalData = {
   userName:"Cargando",
   email:"a@a.es",
   lastname:"rubio",
   name:"gabi",
   passwordHash:"jjj",
   roles:['ROLE_ADMIN']
  };

  id:number;

  constructor(private router:Router,private login:LoginService, private users: UserService,private projectService:ProjectService, private activatedRoute: ActivatedRoute, private http: Http) {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.getUser();
  }
  getUser(){
    this.user = this.users.getPersonalData()
  }

  donate(money:number){
      let donat= new Donation(money,this.id)
      return this.projectService.donateProject(donat).subscribe(
        response=>{this.router.navigate(['/project',this.id]);},
           error => console.log(error)
      ) 
  }
}