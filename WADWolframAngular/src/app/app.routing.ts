import { Routes } from '@angular/router';
//import { User } from './entities/User';
import { IndexComponent } from './entities/Index';
import { AboutComponent } from './entities/About';
import { ContactComponent } from './entities/Contact';
import { RegisterComponet } from './entities/Register';
import { LoginComponent } from './entities/Login';
import { BlogComponent } from './entities/Blog';
import { SingleNewComponent } from './entities/SingleNew';
import { ProjectListComponent } from './entities/ProjectList';
import { ProjectComponent } from './entities/Project';
import { UserDataPageComponent } from './entities/UserDataPage';
import { UserProjectComponent } from './entities/UserProjectsComponent';
import { UserMovementsComponent } from './entities/UserMovementsComponent';

export const  routing : Routes = [
    {path: 'userData', component: UserDataPageComponent },
    {path: 'userProjects', component: UserProjectComponent},
    {path: 'userMovements', component: UserMovementsComponent},
    {path: 'index',  component: IndexComponent},
    {path: 'about', component: AboutComponent},
    {path: 'contact', component: ContactComponent},
    {path: 'register', component: RegisterComponet},
    {path: 'login', component: LoginComponent},
    {path: 'blog', component: BlogComponent},
    {path: 'singleNew/:id', component: SingleNewComponent},
    {path: 'projects', component: ProjectListComponent},
    {path: 'project/:id', component: ProjectComponent},
    {path: '', redirectTo: 'index', pathMatch: 'full' }    
];