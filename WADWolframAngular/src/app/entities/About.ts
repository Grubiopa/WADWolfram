import { Component } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { Http } from '@angular/http';

@Component({

  selector: 'app-root',

  templateUrl: './about.component.html',

  styleUrls: ['../app.component.css']

})


export class AboutComponent{

    constructor(private http:Http){}
      
}