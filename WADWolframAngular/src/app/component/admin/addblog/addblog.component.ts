import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './addblog.component.html'
})

export class AddBlogComponent{ 
  constructor(private router: Router){}
}