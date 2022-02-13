import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Blog } from 'src/app/blog';

@Component({
  selector: 'app-newpost',
  templateUrl: './newpost.component.html',
  styleUrls: ['./newpost.component.css']
})
export class NewpostComponent implements OnInit {
  feild:boolean;

blog;

  constructor(private http:HttpClient, private router:Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    
   this.blog=new Blog;
   this.feild=false;
  }
  
  addBlog(title,content,category):void{
    if(title||content||category){
      this.feild=true;

    }else{
    this.blog.title=title.value;
    this.blog.category=category.value
    this.blog.markdown=content.value;
   this.http.post<Blog>("http://localhost:8000/blog",this.blog).subscribe(result => {
  
    alert("Article created successfully!");
    this.router.navigateByUrl('/blogview/'+result._id);
  });}
  


  }
  

}
