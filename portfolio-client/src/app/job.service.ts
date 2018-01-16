import { Injectable } from '@angular/core';
import { Job } from './job';

@Injectable()
export class JobService {

  constructor() { }

  public getCurrentJob(jobs: Job[]): Job {
    let currentTime = Date.now();
    let currentJobs = jobs.filter(j => j.from.getTime() <= currentTime && (!j.to || j.to.getTime() > currentTime));

    if (currentJobs.length > 1) {
      console.warn("Multiple running jobs found, returning earliest", currentJobs);
    }

    return currentJobs.sort((a, b) => a.from.getTime() - b.from.getTime())[0];
  }
}
