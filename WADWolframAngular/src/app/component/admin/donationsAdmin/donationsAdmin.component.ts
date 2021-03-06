import { Component } from '@angular/core';
import {DonMovement} from '../../../Class/DonMovement';
import {UserService} from '../../../services/UserService';
@Component({
  selector: 'app-root',
  templateUrl: './donationsAdmin.component.html',
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

export class DonationsAdminComponent{
    donations: DonMovement[];
    constructor(private us: UserService){
        this.donations = new Array();
        //this.cargarDonaciones();
    }
    cargarDonaciones(){
        this.us.getDonMovements().subscribe(
            response => {
                this.donations = response;
            }, error => {
                error = console.log(error);
            }
             
        );
    }

}