import {UserProject} from "./UserProject";
import {UserMovements} from "./UserMovements";
import {UserPersonalData} from "./UserPersonalData";

export class User{
   private colaborateProjects;
   private otherProjects;
   private donations;
   private user;

   constructor(colaborateProjets:Array<UserProject>,otherProjects:Array<UserProject>,
    donations:Array<UserMovements>, user:UserPersonalData){
        this.colaborateProjects=colaborateProjets;
        this.otherProjects=otherProjects;
        this.donations=donations;
        this.user=user;
   }
}