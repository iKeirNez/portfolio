import { Experience } from "./experience";

export class Profile {

  constructor(public id: number, public name: string, public headline: string, public biography: string, public experiences: Experience[]) { }

}
