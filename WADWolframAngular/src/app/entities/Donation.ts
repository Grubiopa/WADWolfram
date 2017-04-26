import { Component } from '@angular/core';
import { Donation } from '../class/Donation';
import { User } from '../entities/User';
import { ProjectService } from '../services/ProjectService';

@Component({
  selector: 'donation',
  templateUrl: './donation.html',
  styleUrls: ['../app.component.css']
})

export class DonationComponent{
   file:File;
   user:User;
   constructor(private service: ProjectService){}
    newUserMovement(projectId:number,money:number){
        let donation = new Donation(projectId,money);
        this.service.donateProject(donation).subscribe(
             movement => {
                console.log (movement);
                console.log(this.file);
             }
        );
    }
}