import { Job } from "./job";
import { Education } from "./education";

export class Profile {

  constructor(public id: number, public name: string, public headline: string, public location: string, public biography: string, public jobs: Job[], public educations: Education[]) { }

}
