import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class CovidService {
  url:string;
 
  constructor(private http: HttpClient) { }
  getcountries(): Observable<any> {
    this.url="https://api.covid19api.com/countries";
    return this.http.get<any>(this.url);
 
  }
  getcoronarealdata(country, from, to): Observable<any>{
    this.url=`https://api.covid19api.com/country/${country}?from=${from}T00:00:00Z&to=${to}T00:00:00Z`;
    return this.http.get<any>(this.url);
  
  }
}