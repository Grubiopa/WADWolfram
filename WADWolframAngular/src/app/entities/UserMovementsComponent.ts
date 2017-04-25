import { Component } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { Http } from '@angular/http';

import {UserMovements} from '../entities/UserMovements';

@Component({

  selector: 'app-root',

  templateUrl: './UserMovements.component.html',

  styleUrls: ['../app.component.css']

})


export class UserMovementsComponent{
   file:File;
     
    constructor(){}
   
}