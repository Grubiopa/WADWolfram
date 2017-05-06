import { Component } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {UserPersonalData} from './UserPersonalData'
import {LoginService} from '../services/LoginService';
import {Http} from '@angular/http';

@Component({
  selector: 'login',
  templateUrl: './login.html',
  styleUrls: ['../app.component.css']
})

  export class LoginComponent {

  constructor(private loginService: LoginService, private router: Router) { }

  logIn(event: any, user: string, pass: string) {

    event.preventDefault();

    this.loginService.logIn(user, pass).subscribe(
      u =>{ console.log(u);
        if (this.loginService.getIsAdmin())
        {this.router.navigate(['/admin']);}
        else
        this.router.navigate(['/userProjects']);
      },
      error => alert('Invalid user or password')
    );
  }

  logOut() {
    this.loginService.logOut().subscribe(
      response => { 

       },
      error => console.log('Error when trying to log out: ' + error)
    );
  }

  /*logOut() {
    this.loginService.logOut();
  }*/

}
 