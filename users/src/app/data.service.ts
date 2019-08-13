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
    return this.http.get<User[]>('localhost:8080/users');

  }
}
