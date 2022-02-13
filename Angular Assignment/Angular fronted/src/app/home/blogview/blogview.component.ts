import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Blog } from 'src/app/models/model.blog';

@Component({
  selector: 'app-blogview',
  templateUrl: './blogview.component.html',
  styleUrls: ['./blogview.component.css']
})
export class BlogviewComponent implements OnInit {
  blog:Blog;

  constructor(
    private router: ActivatedRoute,
    private http:HttpClient,
    private routernav:Router) { }

  ngOnInit(): void {
    this.fetchpost();
  }
  private fetchpost(){
    this.http.get<Blog>("http://localhost:8000/blog/"+this.router.snapshot.params["id"]).subscribe(p=>{
    this.blog=p;
    });

}
navigate(blog:Blog){

  this.routernav.navigate(['/editpost/'+blog._id])
  }
  Delete(blog:Blog){

    this.http.delete("http://localhost:8000/blog/"+blog._id).subscribe();
    this.routernav.navigate(['/']);

    }
}