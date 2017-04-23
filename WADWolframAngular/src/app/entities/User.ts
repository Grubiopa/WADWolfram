import {UserProjectComponent} from "../entities/UserProjects";
import {UserMovementsComponent} from "../entities/UserMovements";
import {UserPersonalData} from "../entities/UserPersonalData";

export class User{
   private colaborateProjects: Array<UserProjectComponent>;
   private otherProjects:Array<UserProjectComponent>;
   private donations:Array<UserMovementsComponent>;
   private useruser:UserPersonalData;
}