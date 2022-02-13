import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Userregister } from 'src/app/models/userregister';
import { AuthService } from 'src/app/services/auth.service';
import  countries  from "src/app/utils/countries.json";
import  states  from "src/app/utils/states.json";


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  
  
  userData: Userregister = new Userregister();
   countrylist:{id:string,sortname:string,name:string}[] ;
   statesdemo:{id:string,name:string,country_id:string}[] ;
   
  statelist: Array<string>;
  registered = false;
  getData = false;
  isNew = true;


  emailPattern =  /^(?!.*[A-Z])(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@nagarro.com$/;
  telephonePattern = /^\d{10,15}$/;

  constructor(
    private authService: AuthService,
    private router: Router,
  
  ) { 
    
  }
  ngOnInit(): void {
  this.countrylist=countries;
  this.statesdemo=states;
  this.statelist=[];
  
  console.log(this.countrylist)

 }

  onSubmit(form: NgForm) {
    this.registered = true;
    if (!form.valid) {
      return;
    }
    if (this.isNew) {
      this.isNew = false;
      this.authService.signup(this.userData).subscribe(
        async (data) => {
          console.log(data);
          this.userData = data;
          await this.userData;
          if (this.userData) {
            this.getData = true;
          
          }
        },
        (error) => {
          alert('Email already associated with another account!');
          this.router.navigate(['login']);

        }
      );
    } else {
      this.authService.updateUser(this.userData).subscribe(
        async (data) => {
          this.userData = data;
          await this.userData;
          if (this.userData) {
            this.getData = true;
          }
        },
        (error) => {
          console.log(error);
        }
      );
    }
    form.reset();
  }

  onPrint() {
    window.print();
  }

  editData() {
    this.registered = false;
    this.getData = false;
  }
  changeCountry(countryName:any) {
    let id:string;
    for (let i = 0; i < this.countrylist.length; i++) {
      if(this.countrylist[i].name===countryName){
        id=this.countrylist[i].id;
        console.log(id);
        break;
      }
    }
    for (let i = 0; i <this.statesdemo.length ; i++) {
      if(this.statesdemo[i].country_id===id){
        this.statelist.push(this.statesdemo[i].name);
      }
    }
    
    
    
     //this.state = this.statesdemo.find((country) => country.country_id === id).name;
  }
  cancel(){
    this.registered = true;
    this.getData = true;
  }
}
