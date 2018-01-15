import { Component, OnInit, Input } from '@angular/core';
import { ProfileBasic } from '../profile-basic';

@Component({
  selector: 'app-sidebar-info',
  templateUrl: './sidebar-info.component.html',
  styleUrls: ['./sidebar-info.component.css']
})
export class SidebarInfoComponent implements OnInit {

  @Input() profile: ProfileBasic;

  constructor() { }

  ngOnInit() {
  }

}
