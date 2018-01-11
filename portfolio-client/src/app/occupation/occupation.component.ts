import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-occupation',
  templateUrl: './occupation.component.html',
  styleUrls: ['./occupation.component.css']
})
export class OccupationComponent implements OnInit {

  @Input() headline: string;
  @Input() location: string;
  @Input() website: string;
  @Input() from: Date;
  @Input() to: Date;
  @Input() description: string;

  constructor() { }

  ngOnInit() {
  }

}
