import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { DonationComponent } from './donations/donations.component';
import { IndexAdminComponent } from './index/index';
import { ProfileComponent } from './profile/profile.component';
import { AddProjectComponent } from './addproject/addproject.component';
import { AddBlogComponent } from './addblog/addblog.component';


const adminRoutes: Routes = [
  {
    path: 'admin',
    component: AdminComponent,
    children: [
      {
        path: '', redirectTo:'index',
        children: [
          { path: 'donations', component: DonationComponent },
          { path: 'profile', component: ProfileComponent },
          { path: 'project', component: AddProjectComponent },
          { path: 'news', component: AddBlogComponent },
          { path: 'index', component: IndexAdminComponent }
         
        ]
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(adminRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AdminRoutingModule {
}