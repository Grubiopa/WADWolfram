import {Project} from './Project';
import {UserPersonalData} from '../entities/UserPersonalData';

export interface DonMovement {
  project: Project;
  user: UserPersonalData;
  money:number;
  date: Date;
}