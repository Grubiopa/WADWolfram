import { BrowserModule } from '@angular/platformbrowser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { HttpModule, JsonpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { IndexComponent } from './indexComponent';
import { ProjectComponent } from './projectComponent';
import { ProjectsListComponent } from './projectsListComponent';
import { NewComponent } from './newComponent';
import { NewsListComponent } from './newsListComponent';
import { AboutComponent } from './aboutUsComponent';
import { ContactComponent } from './contactComponent';
import { RegisterComponent } from './registerComponent';
import { LoginComponent } from './loginComponent';
@NgModule({
declarations: [AppComponent, ProjectComponent, ProjectsListComponent, NewComponent, NewsListComponent, IndexComponent, AboutComponent, ContactComponent, RegisterComponent, LoginComponent],
imports: [BrowserModule, FormsModule, HttpModule, JsonpModule],
bootstrap: [AppComponent]
providers: [ProjectService, NewService]
})
export class AppModule { }
