import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  emailPattern = /^(?!.*[A-Z])(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@nagarro.com$/;
  emailSent: boolean = false;
  constructor(private authService: AuthService, private router: Router) { }
  ngOnInit(): void {
  }
  onSubmit(form: NgForm) {
    if (!form.valid) {
      return;
    }
    this.emailSent = true;
    this.authService.forgotPassword(form.value.email).subscribe(
      async (data) => {
        if (data.message == 'success') {
          this.router.navigate(['login']);
        }
      },
      (error) => {
        this.emailSent = false;
        alert("No account associated with email!");
      }
    );
  }
}
