import { Profile } from "./profile";

export class Site {

  constructor(public id: number, public profile: Profile, public title: string, public links: Link[]){ }

}

export class Link {

  constructor(public id: number, public name: string, public icon: string, public url: string) { }

}
