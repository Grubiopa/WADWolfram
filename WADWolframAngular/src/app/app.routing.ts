import { Routes } from '@angular/router';

import { User } from './entities/User';
import { IndexComponent } from './entities/Index';






export const  routing : Routes = [

    { path: 'user', component: User },
    {path:'index',  component:IndexComponent},
    { path: '', redirectTo: 'index', pathMatch: 'full' }

  

    

];