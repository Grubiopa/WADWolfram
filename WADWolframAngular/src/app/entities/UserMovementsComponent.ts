import { Component } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { Http } from '@angular/http';

import {UserMovements} from '../entities/UserMovements';


@Component({

  selector: 'userMovement',

  templateUrl: './userMovements.component.html',

  styleUrls: ['../app.component.css']

})


export class UserMovementsComponent{
    username:string = "cargando";
    movimientos:UserMovements[];  
    constructor(){
      this.movimientos = new Array();
      this.prueba();
      //this.username = this.cargarUserName();
    }
    
    cargarUserName(){
      return "aqui ira la peticion"; 
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