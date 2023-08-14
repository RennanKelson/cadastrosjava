import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./pages/signin-signup/signin-signup.module').then((m) => m.SigninSignupModule)
  },
  {
    path: 'training',
    loadChildren: () => import('./pages/training/training.module').then((m) => m.TrainingModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
