import { BrowserModule, Title } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { SiteHeaderComponent } from './site-header/site-header.component';
import { SiteFooterComponent } from './site-footer/site-footer.component';
import { SiteService } from './site.service';
import { HttpClientModule } from '@angular/common/http';
import { ProfileService } from './profile.service';
import { OccupationComponent } from './occupation/occupation.component';
import { WorkExperienceComponent } from './work-experience/work-experience.component';
import { LayoutSectionComponent } from './layout-section/layout-section.component';


@NgModule({
  declarations: [
    AppComponent,
    SiteHeaderComponent,
    SiteFooterComponent,
    OccupationComponent,
    WorkExperienceComponent,
    LayoutSectionComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, NgbModule.forRoot()
  ],
  providers: [SiteService, ProfileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
