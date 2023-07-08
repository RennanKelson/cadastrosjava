import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SigninSignupComponent } from './signin-signup.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {
    path: '',
    component: SigninSignupComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SigninSignupRoutingModule { }
