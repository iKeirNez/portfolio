import { Component, OnInit, Input } from '@angular/core';
import { Profile } from '../profile';
import { Job } from '../job';
import { JobService } from '../job.service';

@Component({
  selector: 'app-sidebar-info',
  templateUrl: './sidebar-info.component.html',
  styleUrls: ['./sidebar-info.component.css']
})
export class SidebarInfoComponent implements OnInit {

  @Input() profile: Profile;

  currentJob: Job;

  constructor(private jobService: JobService) { }

  ngOnInit() {
    this.currentJob = this.jobService.getCurrentJob(this.profile.jobs);
  }

}
