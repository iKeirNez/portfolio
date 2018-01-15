import { Component, OnInit, Input } from '@angular/core';
import { Education } from '../education';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  @Input() educations: Education[]

  constructor() { }

  ngOnInit() {
    console.log('educations', this.educations);
  }

}
