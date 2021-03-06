import { NgModule } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { SiteHeaderComponent } from './site-header/site-header.component';
import { SiteFooterComponent } from './site-footer/site-footer.component';
import { SiteService } from './site.service';
import { ProfileService } from './profile.service';
import { WorkExperienceComponent } from './work-experience/work-experience.component';
import { LayoutSectionComponent } from './layout-section/layout-section.component';
import { EducationComponent } from './education/education.component';
import { SidebarInfoComponent } from './sidebar-info/sidebar-info.component';
import { JobService } from './job.service';


@NgModule({
  declarations: [
    AppComponent,
    SiteHeaderComponent,
    SiteFooterComponent,
    WorkExperienceComponent,
    LayoutSectionComponent,
    EducationComponent,
    SidebarInfoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
  ],
  providers: [SiteService, ProfileService, JobService],
  bootstrap: [AppComponent]
})
export class AppModule { }
