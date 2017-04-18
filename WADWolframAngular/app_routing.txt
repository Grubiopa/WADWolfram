import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './indexComponent';
import { ProjectComponent } from './projectComponent';
import { ProjectsListComponent } from './projectsListComponent';
import { NewComponent } from './newComponent';
import { NewsListComponent } from './newsListComponent';
import { AboutComponent } from './aboutUsComponent';
import { ContactComponent } from './contactComponent';
import { RegisterComponent } from './registerComponent';
import { LoginComponent } from './loginComponent';
const appRoutes = [
{ path: 'project/:id', component: ProjectComponent },
{ path: 'projectss', component: ProjectsListComponent }, },
{ path: 'new/:id', component: NewComponent }, },
{ path: 'news', component: NewsListComponent }, },
{ path: 'index', component: IndexComponent }, },
{ path: 'about', component: AboutComponent }, },
{ path: 'contact', component: ContactComponent }, },
{ path: 'register', component: RegisterComponent }, },
{ path: 'login', component: LoginComponent }, },
]
export const routing = RouterModule.forRoot(appRoutes);
