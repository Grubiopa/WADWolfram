import { Component } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { Http } from '@angular/http';

import {UserMovements} from '../entities/UserMovements';
import {UserService} from '../services/UserService';
import {LoginService} from '../services/LoginService';

@Component({

  selector: 'userMovement',

  templateUrl: './userMovements.component.html',

  styleUrls: ['../app.component.css']

})


export class UserMovementsComponent{
    username:string = "cargando";
    movimientos:UserMovements[];

    constructor(private router:Router, private login:LoginService,private users: UserService, private activatedRoute: ActivatedRoute, private http: Http){
      this.movimientos = new Array();
      //this.prueba();
      this.username = this.cargarUserName();
      this.cargarUserMovimientos();
    }
    
    logOut() {
    this.login.logOut().subscribe(
      response => { 
          this.router.navigate(['/index']);
       },
      error => console.log('Error when trying to log out: ' + error)
    );
  }

    cargarUserMovimientos(){
      return this.users.getMovements().subscribe(
      response=>this.movimientos = response,
      error => console.log(error)
      )
    } 
    cargarUserName(){
      return this.login.getUser().userName;
    }
    
    prueba(){
     let movimiento:UserMovements={
      date : new Date(),
      money:5000,
      projectTitle:"Proyecto 1"
    };
    let movimiento2:UserMovements={
      date : new Date(),
      money:5000,
      projectTitle:"Proyecto 2"
    };
     this.movimientos.push(movimiento);
     this.movimientos.push(movimiento2);
   }
}