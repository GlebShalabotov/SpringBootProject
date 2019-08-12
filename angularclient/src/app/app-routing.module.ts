import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {WerkgeverComponent} from './werkgever/werkgever.component'
import {WerknemerComponent} from "./werknemer/werknemer.component";

const routes: Routes = [
  {path: 'werkgever', component: WerkgeverComponent},
  {path: 'werknemer', component: WerknemerComponent}

];
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
