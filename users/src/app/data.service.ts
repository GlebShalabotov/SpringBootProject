import { Injectable } from '@angular/core';
import {Observable, timer} from "rxjs";

import {HttpClient} from "@angular/common/http";
import {User} from "./user";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
    console.log("lets get those basterds");
    return this.http.get<User[]>('http://localhost:8080/users');

  }
}
