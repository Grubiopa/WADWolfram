import { Component, OnInit } from '@angular/core';
import  {  Router,  ActivatedRoute  }  from  '@angular/router';
import {Http} from '@angular/http';
import { UserService } from '../services/UserService';
import {UserPersonalData} from './UserPersonalData';
import {UserUpdate} from './UserUpdate';
import {LoginService} from '../services/LoginService';

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
  
  constructor(private router:Router,private login:LoginService, private users: UserService, private activatedRoute: ActivatedRoute, private http: Http) {
    this.getUser();
  }
  
  getUser(){
    this.user = this.users.getPersonalData()
  }

  updateUser(name:string,lastname:string,username:string,email:string,pass1:string,pass2:string){
       
       let realEmail:string = this.user.email;
       let realUserName:string = this.user.userName;
       if(email!=""){
        realEmail=email
       }
       if(username!=""){
         realUserName=username
       }
    let user2: UserUpdate ={    
      email:realEmail,
      username:realUserName,
      oldPassword:pass1,
      newPassword:pass2     
    };
    this.users.updateUser(this.user.id,user2).subscribe(
      response=>{this.login.setUser(response),
       this.router.navigate(['userProjects'])},      
      error => {
        console.log(error);
        this.changes=true
      });
    
  }
}