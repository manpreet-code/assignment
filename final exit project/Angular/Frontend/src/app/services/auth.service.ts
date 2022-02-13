import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';
import { Userregister } from '../models/userregister';

@Injectable({
  providedIn: 'root',
})
export class AuthService {

  constructor(private http: HttpClient) { }

  adminLogin(userName: string, password: string) {
    return this.http.post<any>(environment.apiUrl + '/users/admin-login', { userName, password })
      .pipe(
        map((data) => {
          if ("invalid" === data.message) {
            return false;
          }
          localStorage.setItem('jwtToken', data.message);
          localStorage.setItem('role', "admin");
          return true;
        })
      );
  }
  login(userName: string, password: string): Observable<any> {
    return this.http
      .post<any>(environment.apiUrl + '/users/login', { userName, password })
      .pipe(
        map((data) => {
          if ("invalid" === data.message) {
            return false;
          }
          else {
            localStorage.setItem('jwtToken', data.message);
            localStorage.setItem('role', "user");
            return true;
          }
        })
      );
  }

  forgotPassword(email: string): Observable<any> {
    return this.http.post<any>(environment.apiUrl + '/users/forgot-password?email=' + email, {});
  }
  
  signup(userData: Userregister): Observable<any> {
    let firstName = userData.firstName;
    let lastName = userData.lastName;
    let buisnessUnit = userData.buisnessUnit;
    let title = userData.title;
    let email = userData.email;
    let telephone = userData.telephone;
    let address1 = userData.address1;
    let address2 = userData.address2;
    let city = userData.city;
    let state = userData.state;
    let zip = userData.zip;
    let country = userData.country;

    return this.http
      .post<Userregister>(environment.apiUrl + '/users/signup', {
        firstName,
        lastName,
        buisnessUnit,
        title,
        email,
        telephone,
        address1,
        address2,
        city,
        state,
        zip,
        country,
      })
      .pipe(
        map((data) => {
          return data;
        })
      );
  }

  updateUser(userData: Userregister): Observable<any> {
    let id = userData.id;
    let firstName = userData.firstName;
    let lastName = userData.lastName;
    let buisnessUnit = userData.buisnessUnit;
    let title = userData.title;
    let email = userData.email;
    let telephone = userData.telephone;
    let address1 = userData.address1;
    let address2 = userData.address2;
    let city = userData.city;
    let state = userData.state;
    let zip = userData.zip;
    let country = userData.country;
    return this.http.put<Userregister>(environment.apiUrl + '/users/update', {
      id,
      firstName,
      lastName,
      buisnessUnit,
      title,
      email,
      telephone,
      address1,
      address2,
      city,
      state,
      zip,
      country,
    });
  }
  isAuthenticated(): boolean {
    return localStorage.getItem('jwtToken') != null;
  }
  isAdmin(): boolean {
    const check = (localStorage.getItem('jwtToken') != null) && (localStorage.getItem('role') == 'admin');
    return check;
  }
  isUser(): boolean {
    const check = (localStorage.getItem('jwtToken') != null) && (localStorage.getItem('role') == 'user');
    return check;
  }
}
