import {UserProjectComponent} from "../entities/UserProjects";
import {UserMovementsComponent} from "../entities/UserMovements";
import {UserPersonalData} from "../entities/UserPersonalData";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import{Router} from "@angular/router";
import {Http, Headers} from "@angular/http";
import "rxjs/Rx";

@Injectable()
export class UserService{
   private colaborateProjects;
   private otherProjects;
   private donations;
   private user;

  /* constructor(colaborateProjets:Array<UserProjectComponent>,otherProjects:Array<UserProjectComponent>,
    donations:Array<UserMovementsComponent>, user:UserPersonalData){
        this.colaborateProjects=colaborateProjets;
        this.otherProjects=otherProjects;
        this.donations=donations;
        this.user=user;
    }*/
    constructor(){}
}