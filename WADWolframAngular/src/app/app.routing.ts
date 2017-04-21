import { Routes } from '@angular/router';

//import { User } from './entities/User';
import { IndexComponent } from './entities/Index';
import {AboutComponent} from './entities/About';
import {BlogComponent} from './entities/Blog';
import {RegisterComponet} from './entities/Register';
import {LoginComponent} from './entities/Login';
import{UserDataPageComponent} from './entities/UserDataPage';
import{UserProjectComponent} from './entities/UserProjects';
import{UserMovementsComponent}from './entities/UserMovements';
import{ContactComponent}from './entities/Contact';
export const  routing : Routes = [

    { path: 'userData', component: UserDataPageComponent },
    {path: 'userProjects', component: UserProjectComponent},
    {path: 'userMovements', component: UserMovementsComponent},
    {path:'index',  component:IndexComponent},
    {path:'about', component:AboutComponent},
    {path:'blog', component:BlogComponent},
    {path:'register', component:RegisterComponet},
    {path:'login', component:LoginComponent},
    {path:'contact',component:ContactComponent},
    { path: '', redirectTo: 'index', pathMatch: 'full' }

  

    

];