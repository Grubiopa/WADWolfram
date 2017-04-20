import { Component, OnInit  } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

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
