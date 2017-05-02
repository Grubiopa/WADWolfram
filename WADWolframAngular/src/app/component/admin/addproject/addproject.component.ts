import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {ProjectService} from '../../../services/ProjectService';

@Component({
  selector: 'app-root',
  templateUrl: './addproject.component.html'
  
})

export class AddProjectComponent{ 
    constructor(private router: Router, private service: ProjectService){}

}