import { Component, OnInit, Input } from '@angular/core';
import { Site } from '../site';
import { SocialLink } from '../social-link';

@Component({
  selector: 'site-header',
  templateUrl: './site-header.component.html',
  styleUrls: ['./site-header.component.css']
})
export class SiteHeaderComponent implements OnInit {

  @Input() title: string;
  @Input() headline: string;
  @Input() photoUrl: string;
  @Input() links: SocialLink[];

  constructor() { }

  ngOnInit() {
  }

}
