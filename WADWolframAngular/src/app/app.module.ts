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
import {RegisterComponet} from './entities/Register';

@NgModule({
  declarations: [
    AppComponent,IndexComponent, AboutComponent, RegisterComponet
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,JsonpModule,NgbModule.forRoot(), RouterModule.forRoot(routing)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
