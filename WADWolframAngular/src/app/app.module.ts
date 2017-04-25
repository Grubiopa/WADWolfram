import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule,JsonpModule } from '@angular/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { RouterModule } from '@angular/router';

import { IndexComponent } from './entities/Index';
import {AboutComponent} from './entities/About';
import {BlogComponent} from './entities/Blog';
import {SingleNewComponent} from './entities/SingleNew';
import {ProjectListComponent} from './entities/ProjectListComponent';
import {ProjectComponent} from './entities/ProjectComponent';
import {RegisterComponet} from './entities/Register';
import {LoginComponent} from './entities/Login';
import {UserDataPageComponent} from './entities/UserDataPage';
import{UserProjectComponent} from './entities/UserProjects';
import{UserMovementsComponent}from './entities/UserMovementsComponent';
import{ContactComponent}from './entities/Contact';
import {UserService} from './services/UserService';
import {NewService} from './services/NewService';

@NgModule({
  declarations: [
    AppComponent,IndexComponent, AboutComponent, BlogComponent, SingleNewComponent, ProjectListComponent, ProjectComponent, RegisterComponet, LoginComponent, UserDataPageComponent,
    UserProjectComponent,UserMovementsComponent,ContactComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,JsonpModule,NgbModule.forRoot(), RouterModule.forRoot(routing)
  ],
  providers: [UserService,NewService],
  bootstrap: [AppComponent]
})
export class AppModule { }
