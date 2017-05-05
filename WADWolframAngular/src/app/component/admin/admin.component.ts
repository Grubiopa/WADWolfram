import {Component, OnInit} from '@angular/core';

//import {SessionService} from '../../service/session.service';
//import {UserService} from '../../service/user.service';

@Component({
    templateUrl: './admin.component.html',
    styleUrls:['../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap-theme.css',
    '../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap-theme.min.css',
    '../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap.css',
    '../../../assets/Bootstrap-Admin-Theme/bootstrap/css/bootstrap.min.css',
    '../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.eot',
    '../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.svg',
    '../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.ttf',
    '../../../assets/Bootstrap-Admin-Theme/bootstrap/fonts/glyphicons-halflings-regular.woff',
    '../../../assets/Bootstrap-Admin-Theme/css/buttons.css',
    '../../../assets/Bootstrap-Admin-Theme/css/calendar.css',
    '../../../assets/Bootstrap-Admin-Theme/css/forms.css',
    '../../../assets/Bootstrap-Admin-Theme/css/stats.css',
    '../../../assets/Bootstrap-Admin-Theme/css/styles.css'
  /*'../../../assets/Bootstrap-Admin-Theme/bootstrap/js/bootstrap.js',
    '../../../assets/Bootstrap-Admin-Theme/bootstrap/js/bootstrap.min.js',
    '../../../assets/Bootstrap-Admin-Theme/css/buttons.css',
    '../../../assets/Bootstrap-Admin-Theme/css/calendar.css',
    '../../../assets/Bootstrap-Admin-Theme/css/forms.css',
    '../../../assets/Bootstrap-Admin-Theme/css/stats.css',
    '../../../assets/Bootstrap-Admin-Theme/css/styles.css',
    '../../../assets/Bootstrap-Admin-Theme/js/calendar.js',
    '../../../assets/Bootstrap-Admin-Theme/js/custom.js',
    '../../../assets/Bootstrap-Admin-Theme/js/editors.js',
    '../../../assets/Bootstrap-Admin-Theme/js/forms.js',
    '../../../assets/Bootstrap-Admin-Theme/js/stats.js',
    '../../../assets/Bootstrap-Admin-Theme/js/tables.js'*/]    
})
export class AdminComponent {

  private menuCollapse: boolean = true;
  private showMenu: boolean = true;
  private showMenu2: boolean = true;
  
  showDropdown(typeMenu: string) {// Método encargado de los dropdowns del navbar

    if (typeMenu === "collapse") {

      this.menuCollapse = !this.menuCollapse;

    } else if (typeMenu === "latMenu") {

      this.showMenu2 = !this.showMenu2;

    }

  }

  showDrop(typeMenu: string) {// Método encargado de los dropdowns del navbar

    if (typeMenu === "collapse") {

      this.menuCollapse = !this.menuCollapse;

    } else if (typeMenu === "loginMenu") {

      this.showMenu = !this.showMenu;

    }

  }

}