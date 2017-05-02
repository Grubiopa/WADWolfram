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
import {DonationComponent} from './entities/Donation';
import {UserDataPageComponent} from './entities/UserDataPage';
import {UserProjectComponent} from './entities/UserProjectsComponent';
import {UserMovementsComponent} from './entities/UserMovementsComponent';
import {UserService} from './services/UserService';
import {NewService} from './services/NewService';
import {ProjectService} from './services/ProjectService';
import { AdminComponent } from './component/admin/admin.component';
import { IndexAdminComponent } from './component/admin/index/index';
import { AddProjectComponent } from './component/admin/addproject/addproject.component';
import { AddBlogComponent } from './component/admin/addblog/addblog.component';

import { PublicComponent } from './public.component';

@NgModule({
  declarations: [
    AppComponent, IndexComponent, AboutComponent, BlogComponent, SingleNewComponent, ProjectListComponent, ProjectComponent, RegisterComponet, LoginComponent, DonationComponent, UserDataPageComponent,
    UserProjectComponent, UserMovementsComponent, ContactComponent, PublicComponent, AdminComponent, IndexAdminComponent, AddBlogComponent, AddProjectComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpModule, JsonpModule, NgbModule.forRoot(), routing
  ],
  providers: [UserService, NewService, ProjectService, appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }

/* 
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { routing ,appRoutingProviders} from './app.routing';
import {Ng2PageScrollModule} from 'ng2-page-scroll';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { SearchBoxService } from './searchbox/searchbox.service';
import { SearchBoxComponent } from './searchbox/searchbox.component';

import { EventsComponent } from './events/events.component';
import { EventService} from './events/events.service';
import { EventDetailComponent} from './events/event-detail.component';
import { EventCreateComponent } from './events/event-create.component';

import { CommunitiesComponent } from './communities/communities.component';
import { CommunitiesCreate } from './communities/communities-create.component';
import { CommunityDetailComponent } from './communities/communities-detail.component';
import { CommunityService} from './communities/communities.service';

import { UserComponent } from './user/user.component';
import { UserService } from './user/user.service';
import { StatsService } from './stat/stats.service';

import {PublicComponent} from './public.component';
import {PrivateComponent} from './admin/admin.component';
import AdminEvents from './admin/admin-events.component';
import AdminCommunities from './admin/admin-communities.component';
import AdminUsers from './admin/admin-users.component';

import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';
import { HttpClient } from "./HttpClient/httpClient";

import { Ng2GoogleChartsModule } from 'ng2-google-charts';
import { ProgressBarModule } from 'primeng/primeng';
import { ChartModule } from 'primeng/primeng'; 
import { TabViewModule } from 'primeng/primeng';
import {DataListModule} from 'primeng/primeng';
import {DataTableModule,SharedModule} from 'primeng/primeng';
import {GrowlModule} from 'primeng/primeng';
import{GalleriaModule} from 'primeng/primeng';




@NgModule({
  declarations: [
    AppComponent, NavbarComponent, FooterComponent, HomeComponent, EventsComponent, EventDetailComponent,
    CommunitiesComponent,CommunityDetailComponent,CommunitiesCreate, UserComponent, LoginComponent,EventCreateComponent,
    PrivateComponent,AdminEvents,AdminCommunities,AdminUsers,PublicComponent,SearchBoxComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgbModule.forRoot(),
    routing,
    Ng2PageScrollModule.forRoot(),
    Ng2GoogleChartsModule,
    ProgressBarModule,
    ChartModule,
    TabViewModule,
    DataListModule,
    DataTableModule,
    SharedModule,
    GrowlModule,
    GalleriaModule
  ],
  providers: [EventService, CommunityService , LoginService, UserService,HttpClient,appRoutingProviders, SearchBoxService, StatsService],
  bootstrap: [AppComponent]
})
export class AppModule { }

*/