import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { NewTicketComponent } from './ticket/new-ticket/new-ticket.component';
import { EditTicketComponent } from './ticket/edit-ticket/edit-ticket.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { LoginComponent } from './user/login/login.component';
import { SignupComponent } from './user/signup/signup.component';
import { FormsModule } from '@angular/forms';
import { HttpClientInterceptor } from './Http-Client-Interceptor';
import { EditTicketAdminComponent } from './ticket/edit-ticket-admin/edit-ticket-admin.component';
import { ViewTicketComponent } from './ticket/viewTicket/viewTicket.component';
import { ForgotPasswordComponent } from './user/forgot-password/forgot-password.component';
import { DashboardComponent } from './user/dashboard/dashboard.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { CovidComponent } from './covid/covid.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    HomeComponent,
    NewTicketComponent,
    EditTicketComponent,
    EditTicketAdminComponent,
    ViewTicketComponent,
    LoginComponent,
    SignupComponent,
    NotFoundComponent,
    AdminDashboardComponent,
    ForgotPasswordComponent,
    DashboardComponent,
    AdminLoginComponent,
    CovidComponent
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpClientInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }
