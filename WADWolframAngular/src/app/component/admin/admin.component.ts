import {Component, OnInit} from '@angular/core';

//import {SessionService} from '../../service/session.service';
//import {UserService} from '../../service/user.service';

@Component({
    templateUrl: './admin.component.html',
    styleUrls:['../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap-theme.css',
    '../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap-theme.min.css',
    '../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap.css',
    '../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap.min.css',
    '../../../assets/Bootstrap-Admin-Theme/css/buttons.css',
    '../../../assets/Bootstrap-Admin-Theme/css/forms.css',
    '../../../assets/Bootstrap-Admin-Theme/css/styles.css']    
})
export class AdminComponent {

  private menuCollapse: boolean = true;
  private showMenu: boolean = true;
  
  showDropdown(typeMenu: string) {// Método encargado de los dropdowns del navbar

    if (typeMenu === "collapse") {

      this.menuCollapse = !this.menuCollapse;

    } else if (typeMenu === "loginMenu") {

      this.showMenu = !this.showMenu;

    }

  }

}