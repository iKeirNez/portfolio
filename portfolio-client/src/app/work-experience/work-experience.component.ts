import { Component, OnInit, Input } from '@angular/core';
import { Job } from '../job';

@Component({
  selector: 'app-work-experience',
  templateUrl: './work-experience.component.html',
  styleUrls: ['./work-experience.component.css']
})
export class WorkExperienceComponent implements OnInit {

  @Input() jobs: Job[]

  constructor() { }

  ngOnInit() {
    console.log('jobs', this.jobs);
  }

}
