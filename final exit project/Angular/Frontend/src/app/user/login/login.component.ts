import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {


  constructor(private authService: AuthService, private router: Router) { }

  formSubmit: boolean = false;
  ngOnInit(): void {
  }
  onSubmit(form: NgForm) {
    if (!form.valid) {
      return;
    }
    this.formSubmit = true;
    this.authService.login(form.value.username, form.value.password).subscribe(
      (data) => {
        if (data) {
          this.router.navigate(['']);
          return;
        }
        else {
          alert("Invalid user details!");
          this.formSubmit = false;
        }
      },
      (error) => {
        alert("Invalid user details!");
        this.formSubmit = false;
      }
    );
    form.reset();
  }
}
