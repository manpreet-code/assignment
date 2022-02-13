import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BlogviewComponent } from './home/blogview/blogview.component';
import { EditComponent } from './home/edit/edit.component';
import { IndexComponent } from './home/index/index.component';
import { NewpostComponent } from './home/newpost/newpost.component';

const routes: Routes = [{path:"",component:IndexComponent},
                        {path:"newpost",component:NewpostComponent},
                        {path:"editpost/:id",component:EditComponent},
                        {path:"blogview/:id",component:BlogviewComponent},
                        {path:"index",component:IndexComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
