import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  count: any;
  contry: any;
  comfirm: number;
  deaths: number;
  active: number;
  constructor() { }

  ngOnInit(): void {
    
  }
  
  
}
