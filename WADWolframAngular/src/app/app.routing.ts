import { Routes } from '@angular/router';
import {RouterModule} from '@angular/router';
//import { User } from './entities/User';

import { AdminComponent } from './component/admin/admin.component';
import { IndexAdminComponent } from './component/admin/index/index';
import { AddProjectComponent } from './component/admin/addproject/addproject.component';
import { AddBlogComponent } from './component/admin/addblog/addblog.component';
import { DonationsAdminComponent } from './component/admin/donationsAdmin/donationsAdmin.component';
import { ProfileComponent } from './component/admin/profile/profile.component';

import { PublicComponent } from './public.component';

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
/*
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
   
    {path: '', redirectTo: 'index', pathMatch: 'full'}
];
*/
const appRoutes: Routes = [
    { path: '', component: PublicComponent,
        children: [
            {path: '', redirectTo: 'index', pathMatch: 'full'},
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
        ]
    },

    {
        path: 'admin', component: AdminComponent,

        children: [
            { path: '', redirectTo: '/admin/index', pathMatch: 'full' },
            { path: 'index', component: IndexAdminComponent },
            { path: 'projects', component: AddProjectComponent },
            { path: 'blog', component: AddBlogComponent },
            { path: 'donations', component: DonationsAdminComponent },
            { path: 'profile', component: ProfileComponent },
        ]
    }
]
export const appRoutingProviders: any[] = []
export const routing = RouterModule.forRoot(appRoutes);
