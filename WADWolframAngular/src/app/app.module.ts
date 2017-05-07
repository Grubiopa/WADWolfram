import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule,JsonpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { routing,appRoutingProviders } from './app.routing';
import { RouterModule } from '@angular/router';
import {AppRoutingModule} from './app-routing.module';

import {IndexComponent} from './entities/Index';
import {AboutComponent} from './entities/About';
import {ContactComponent} from './entities/Contact';
import {RegisterComponet} from './entities/Register';
import {LoginComponent} from './entities/Login';
import {BlogComponent} from './entities/Blog';
import {SingleNewComponent} from './entities/SingleNew';
import {ProjectListComponent} from './entities/ProjectList';
import {ProjectComponent} from './entities/Project';
import {UserDataPageComponent} from './entities/UserDataPage';
import {UserProjectComponent} from './entities/UserProjectsComponent';
import {UserMovementsComponent} from './entities/UserMovementsComponent';
import {UserService} from './services/UserService';
import {NewService} from './services/NewService';
import {ProjectService} from './services/ProjectService';
import {LoginService} from './services/LoginService';
import { AdminComponent } from './component/admin/admin.component';
import { IndexAdminComponent } from './component/admin/index/index';
import { AddProjectComponent } from './component/admin/addproject/addproject.component';
import { AddBlogComponent } from './component/admin/addblog/addblog.component';
import { DonationsAdminComponent } from './component/admin/donationsAdmin/donationsAdmin.component';
import { ProfileComponent } from './component/admin/profile/profile.component';
import {PayComponent} from './entities/pay';
import { PublicComponent } from './public.component';

@NgModule({
  declarations: [
    AppComponent, IndexComponent, AboutComponent, BlogComponent, SingleNewComponent, ProjectListComponent, ProjectComponent, RegisterComponet, LoginComponent,  UserDataPageComponent,
    UserProjectComponent, UserMovementsComponent, ContactComponent, PublicComponent, AdminComponent, IndexAdminComponent, AddBlogComponent, AddProjectComponent, DonationsAdminComponent, ProfileComponent,
    PayComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpModule, JsonpModule, NgbModule.forRoot(), routing
  ],
  providers: [UserService, NewService, ProjectService, appRoutingProviders, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }

