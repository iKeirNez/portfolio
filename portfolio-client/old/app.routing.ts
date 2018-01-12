import { Routes } from '@angular/router';

import { AppResolver } from './app.resolver';

export const AppRoutes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: AppComponent,
    resolve: {
      appData: AppResolver
    }
  }
];
