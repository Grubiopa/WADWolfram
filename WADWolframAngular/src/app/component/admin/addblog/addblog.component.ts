import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './addblog.component.html',
  styleUrls: ['../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap-theme.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap-theme.min.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap.min.css',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.eot',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.svg',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.ttf',
    '../../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.woff',
    '../../../../assets/Bootstrap-Admin-Theme/css/buttons.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/calendar.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/forms.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/stats.css',
    '../../../../assets/Bootstrap-Admin-Theme/css/styles.css'] 
})

export class AddBlogComponent{ 
  constructor(private router: Router){}
}