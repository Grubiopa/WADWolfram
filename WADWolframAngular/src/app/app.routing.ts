import { Routes } from '@angular/router';

import { User } from './entities/User';
import { IndexComponent } from './entities/Index';
import {AboutComponent} from './entities/About';






export const  routing : Routes = [

    { path: 'user', component: User },
    {path:'index',  component:IndexComponent},
    {path:'about', component:AboutComponent},
    { path: '', redirectTo: 'index', pathMatch: 'full' }

  

    

];