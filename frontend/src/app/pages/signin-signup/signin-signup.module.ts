import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SigninSignupRoutingModule } from './signin-signup-routing.module';
import { SignupComponent } from './signup/signup.component';


@NgModule({
  declarations: [
    SignupComponent
  ],
  imports: [
    CommonModule,
    SigninSignupRoutingModule
  ]
})
export class SigninSignupModule { }
