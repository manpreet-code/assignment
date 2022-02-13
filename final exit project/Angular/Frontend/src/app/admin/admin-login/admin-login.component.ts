import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  formSubmit: boolean = false;
  ngOnInit(): void {
  }
  onSubmit(form: NgForm) {
    if (!form.valid) {
      return;
    }
    this.formSubmit = true;
    this.authService.adminLogin(form.value.username, form.value.password).subscribe(
      (data) => {
        if (data) {
          this.router.navigate(['admin/dashboard']);
          return;
        }
        else {
          alert("Invalid admin details!");
          this.formSubmit = false;
        }
      },
      (error) => {
        alert("Invalid admin details!");
        this.formSubmit = false;
      }
    );
    form.reset();
  }
}
