import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/models/model.blog';
import {Router} from '@angular/router'


@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor(private http:HttpClient ,private router:Router) {
   }
   loadedData:Blog[]=[];

  ngOnInit(): void {
    this.fetchpost();
  }
  private fetchpost(){
    this.http.get<Blog[]>("http://localhost:8000/blog").subscribe(p=>{
    this.loadedData=p;
    });
  }
  navigate(blog:Blog){

    this.router.navigate(['/blogview/'+blog._id])
    }

}
