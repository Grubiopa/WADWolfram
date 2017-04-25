import { Component } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { Http } from '@angular/http';

import {Donation} from '../entities/Donation';

import{ProjectService} from '../services/ProjectService';

@Component({

  selector: 'donation',

  templateUrl: './UserMovements.component.html',

  styleUrls: ['../app.component.css']

})


export class DonationComponent{
   file:File;

    newUserMovement(projectId:number,money:number){
        let donation = new Donation(projectId,money);
        this.ProjectService.donateProject(donation).subscribe(
             movement => {

                console.log (movement);

                console.log(this.file);
             }
        );
    }
   
   
}