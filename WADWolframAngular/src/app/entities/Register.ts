import { Component } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { Http } from '@angular/http';

@Component({

  selector: 'app-root',

  templateUrl: './register.component.html',

  styleUrls: ['../app.component.css']

})


export class RegisterComponet{

    constructor(private http:Http){}
      
}