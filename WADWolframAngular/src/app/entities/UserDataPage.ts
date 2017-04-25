
import { Component, OnInit } from '@angular/core';

import  {  Router,  ActivatedRoute  }  from  '@angular/router';

import { UserService } from '../services/UserService';

@Component({

  selector: 'app-root',

  templateUrl: './userDataPage.component.html',

  styleUrls: ['../app.component.css'],

})

export class UserDataPageComponent {

  //user: UserService;

  constructor(private router:Router, private users: UserService, private activatedRoute: ActivatedRoute) {

    //let id = this.activatedRoute.snapshot.params['id'];
  }
  

}
