import { Component, OnInit } from '@angular/core';
import {timer} from "rxjs";
import {DataService} from "../data.service";
import {Werkgever} from "../werkgever";

@Component({
  selector: 'app-werkgever',
  templateUrl: './werkgever.component.html',
  styleUrls: ['./werkgever.component.css']
})
export class WerkgeverComponent implements OnInit {


  werkgevers: Werkgever[];

  constructor(private data: DataService) { }

  ngOnInit() {
    this.getWerkgevers();
  }


  getWerkgevers(): void {
    timer(0, 2500)
      .subscribe(() => {
        this.data.getWerkgevers().subscribe(data =>  this.werkgevers = data);

      });
  }
}
