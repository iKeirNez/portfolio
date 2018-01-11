import { Component, OnInit, Input } from '@angular/core';
import { Experience } from '../experience';

@Component({
  selector: 'app-work-experience',
  templateUrl: './work-experience.component.html',
  styleUrls: ['./work-experience.component.css']
})
export class WorkExperienceComponent implements OnInit {

  @Input() jobs: Experience[]

  constructor() { }

  ngOnInit() {
  }

}
