import { Component } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { Http } from '@angular/http';

@Component({

  selector: 'app-root',

  templateUrl: './blog.component.html',

  styleUrls: ['../app.component.css']

})


export class BlogComponent{

    constructor(private http:Http){}
      
}