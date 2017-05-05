import { Component } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {UserPersonalData} from './UserPersonalData'
import {UserService} from '../services/UserService';
import {Http} from '@angular/http';
@Component({
  selector: 'register',
  templateUrl: './register.html',
  styleUrls: ['../app.component.css']
})

export class RegisterComponet{
 
  error:Boolean = false;

  constructor(private router:Router,private http: Http, private service:UserService){}

  newUser(name:string,lastname:string,username:string,email:string,password1:string,password2:string, roles:string[]){
    if(password1==password2){
      let user: UserPersonalData ={
      email:email,
      name:name,
      lastname:lastname,
      passwordHash:password1,
      userName:username,
      roles:roles
      }
      this.service.addUser(user).subscribe(
        user=>{
          console.log(user);
          this.router.navigate(['login']);
        }        
      );
    }else{
      this.error = true;
    }
    
  }
}