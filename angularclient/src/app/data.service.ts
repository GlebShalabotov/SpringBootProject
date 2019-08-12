import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Werkgever} from "./werkgever";
import {Werknemer} from "./werknemer";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private httpOptions = {
    headers : new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'})
  }
  link: string;
  ob: Observable<string>;
  constructor(private http: HttpClient) { }

  getWerkgevers(): Observable<Werkgever[]> {
    return this.http.get<Werkgever[]>('http://localhost:8080/werkgever');
  }

  getWerknemers(): Observable<Werknemer[]> {
    return this.http.get<Werknemer[]>('http://localhost:8080/werknemer');
  }
}
