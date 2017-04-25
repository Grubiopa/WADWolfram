import {UserProjectComponent} from "./UserProjectsComponent";
import {UserMovementsComponent} from "../entities/UserMovementsComponent";
import {UserPersonalData} from "../entities/UserPersonalData";

export class User{
   private colaborateProjects: Array<UserProjectComponent>;
   private otherProjects:Array<UserProjectComponent>;
   private donations:Array<UserMovementsComponent>;
   private useruser:UserPersonalData;
}