import { Component } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {UserPersonalData} from '../../../entities/UserPersonalData';
import {UserService} from '../../../services/UserService';
import {Http} from '@angular/http';

import {UserUpdate} from '../../../entities/UserUpdate';
import {LoginService} from '../../../services/LoginService';

@Component({
  selector: 'appp-root',
  templateUrl: './profile.component.html',
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

export class ProfileComponent{
     error:Boolean = false;
     correcto: Boolean= false;
     changes: Boolean=false;

user: UserPersonalData = {
   userName:"Cargando",
   email:"a@a.es",
   lastname:"rubio",
   name:"gabi",
   passwordHash:"jjj",
   roles:['ROLE_ADMIN']
  };


  constructor(private router:Router,private login:LoginService,private http: Http, private service:UserService,private activatedRoute: ActivatedRoute){
    this.getUser();
  }

   getUser(){
    this.user = this.service.getPersonalData()
  }

  newUser(name:string,email:string,password1:string,password2:string, roles:string[]){
    if(password1==password2){
      let user: UserPersonalData ={
      email:email,
      name:name,
      lastname:null,
      passwordHash:password1,
      userName:null,
      roles:roles
      }
      this.service.addUser(user).subscribe(
        user=>{
          console.log(user);
          this.correcto=true;
          this.router.navigate(['admin/profile']);
        }        
      );
    }else{
      this.error = true;
    }
    
  }

    updateUser(name:string,email:string,pass:string,newpass:string,rnewpass:string){
    
   // if(rnewpass=newpass){
    let user2: UserUpdate ={    
      email:email,
      username:name,
      oldPassword:pass,
      newPassword:newpass     
    };
 // }
 // else{
   // let user2: UserUpdate={email:this.getUser.email,username:this.getUser.name,oldPassword:this.getUser}
    this.service.updateUser(this.user.id,user2).subscribe(
      response=>{this.login.setUser(response),
       this.router.navigate(['admin/index'])},       
      error => {
        console.log(error);
        this.changes=true
      });

  //};
    
  }

 }