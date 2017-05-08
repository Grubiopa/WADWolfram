import { Component} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NewService } from '../services/NewService';
import { LoginService } from '../services/LoginService';
import { New } from '../Class/New';

@Component({
  selector: 'new',
  templateUrl: './singleNew.html',
  styleUrls: ['../app.component.css']
})

export class SingleNewComponent{
  nnew: New={
     title:"nada",
    body:"vacio",
    category:"",
    number_comments:0,
    date:null
  };
  
  id:number;
  
  private noLogeado: boolean = false;
  private Logeado: boolean = false;
  private commentarioos: String[];

    constructor(private _router: Router, private activatedRoute: ActivatedRoute, private service: NewService, private loginService: LoginService) {
      this.commentarioos= new Array();
          this.id = activatedRoute.snapshot.params['id'];
        this.service.getNew(this.id).subscribe(
         nnew => {this.nnew = nnew
        },
          error => console.error(error)
        );
        this.isLogeado();

   }

   isLogeado(){
    this.Logeado = ! this.loginService.getIsLogged();
    this.noLogeado =  this.loginService.getIsLogged();
    
  }

  comentar(coment:string){
    this.commentarioos.push(coment);
    this._router.navigate(['/new',this.id]);
  }
}