import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/models/model.blog';
import {ActivatedRoute,Router} from '@angular/router'

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  blog:Blog;

  constructor(private http:HttpClient ,private routernav:Router,private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.fetchpost();
  }
  private fetchpost(){
    this.http.get<Blog>("http://localhost:8000/blog/"+this.router.snapshot.params["id"]).subscribe(p=>{
    this.blog=p;
    });

}
editBlog(edittitle,editcontent,editcategory){
  this.blog.title=edittitle.value;
    this.blog.category=editcategory.value
    this.blog.markdown=editcontent.value;
   this.http.patch<Blog>("http://localhost:8000/blog/"+this.blog._id,this.blog).subscribe(result => {
  
    alert("Article edited successfully!");
    this.routernav.navigateByUrl('/blogview/'+this.blog._id);
  });
  
}
}
