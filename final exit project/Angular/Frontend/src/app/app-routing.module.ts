import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { HomeComponent } from './home/home.component';

import { NotFoundComponent } from './not-found/not-found.component';
import { EditTicketAdminComponent } from './ticket/edit-ticket-admin/edit-ticket-admin.component';

import { EditTicketComponent } from './ticket/edit-ticket/edit-ticket.component';
import { NewTicketComponent } from './ticket/new-ticket/new-ticket.component';
import { ViewTicketComponent } from './ticket/viewTicket/viewTicket.component';
import { ForgotPasswordComponent } from './user/forgot-password/forgot-password.component';
import { LoginComponent } from './user/login/login.component';
import { SignupComponent } from './user/signup/signup.component';
import { DashboardComponent } from './user/dashboard/dashboard.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { UserGuardService } from './user-guard.service';
import { AdminGuardService } from './admin-guard.service';
import { CovidComponent } from './covid/covid.component';

const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },



  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'forgot-password', component: ForgotPasswordComponent },
  { path: 'dashboard', component: DashboardComponent , canActivate: [AuthGuard, UserGuardService] },

  { path: 'admin/dashboard', component: AdminDashboardComponent ,canActivate: [AuthGuard, AdminGuardService]},
  { path: 'admin/login', component: AdminLoginComponent },

  { path: 'tickets/new-ticket', component: NewTicketComponent , canActivate: [AuthGuard, UserGuardService]},

  { path: 'tickets/edit/:id', component: EditTicketComponent ,canActivate: [AuthGuard, UserGuardService]},
  { path: 'tickets/update/:id', component: EditTicketAdminComponent ,canActivate: [AuthGuard, AdminGuardService]},
  { path: 'tickets/:id', component: ViewTicketComponent ,canActivate: [AuthGuard]},

  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
