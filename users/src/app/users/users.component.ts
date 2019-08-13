import { Component, OnInit } from '@angular/core';
import {timer} from "rxjs";
import {User} from "../user";
import {DataService} from "../data.service";
import {applySourceSpanToExpressionIfNeeded} from "@angular/compiler/src/output/output_ast";


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  gebruikers: User[];

  constructor(private data: DataService) { }

  ngOnInit() {
    this.getUsers();
  }


  getUsers(): void {
    timer(0, 80000)
      .subscribe(() => {
        this.data.getUsers().subscribe(data =>  this.gebruikers = data);
        console.log(this.gebruikers);
      });
  }
}
