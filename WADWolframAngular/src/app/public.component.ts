import { Component,OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {LoginService} from './services/LoginService';

@Component({
  	selector: 'public',
    templateUrl: './public.component.html',
    styleUrls: ['./app.component.css', '../assets/css/bootstrap.min.css', '../assets/css/animate.css', '../assets/css/cubeportfolio.min.css'
  , '../assets/css/custom-fonts.css', '../assets/css/flexslider.css', '../assets/css/font-awesome.css', '../assets/css/overwrite.css'
  , '../assets/css/style.css', '../assets/css/theme.css', '../assets/css/user.css']
})
export class PublicComponent {
  
  private menuCollapse: boolean = true;
  private showMenu: boolean = true;
  private noLogeado: boolean = false;
  private Logeado: boolean = false;
  
  
constructor(private loginService: LoginService, private router: Router) { 

this.isLogeado();
}

  showDropdown(typeMenu: string) {// Método encargado de los dropdowns del navbar

    if (typeMenu === "collapse") {

      this.menuCollapse = !this.menuCollapse;

    } else if (typeMenu === "loginMenu") {

      this.showMenu = !this.showMenu;

    }
    this.isLogeado();
  }

  isLogeado(){
    this.Logeado = this.loginService.getIsLogged();
    this.noLogeado = ! this.loginService.getIsLogged();
    
  }
  

}
