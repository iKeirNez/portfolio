import { Profile } from "./profile";
import { SocialLink } from "./social-link";

export class Site {

  constructor(public id: number, public profile: Profile, public title: string, public links: SocialLink[]){ }

}
