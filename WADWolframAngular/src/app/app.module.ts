import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule,JsonpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { RouterModule } from '@angular/router';

import {IndexComponent} from './entities/Index';
import {AboutComponent} from './entities/About';
import {ContactComponent} from './entities/Contact';
import {RegisterComponet} from './entities/Register';
import {LoginComponent} from './entities/Login';
import {BlogComponent} from './entities/Blog';
import {SingleNewComponent} from './entities/SingleNew';
import {ProjectListComponent} from './entities/ProjectList';
import {ProjectComponent} from './entities/Project';
import {DonationComponent} from './entities/Donation';
import {UserDataPageComponent} from './entities/UserDataPage';
import {UserProjectComponent} from './entities/UserProjectsComponent';
import {UserMovementsComponent} from './entities/UserMovementsComponent';
import {UserService} from './services/UserService';
import {NewService} from './services/NewService';
import {ProjectService} from './services/ProjectService';
@NgModule({
  declarations: [
    AppComponent, IndexComponent, AboutComponent, BlogComponent, SingleNewComponent, ProjectListComponent, ProjectComponent, RegisterComponet, LoginComponent, DonationComponent, UserDataPageComponent,
    UserProjectComponent, UserMovementsComponent, ContactComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpModule, JsonpModule, NgbModule.forRoot(), RouterModule.forRoot(routing)
  ],
  providers: [UserService, NewService, ProjectService],
  bootstrap: [AppComponent]
})
export class AppModule { }