import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SigninSignupRoutingModule } from './signin-signup-routing.module';
import { SignupComponent } from './signup/signup.component';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    SignupComponent
  ],
  imports: [
    CommonModule,
    SigninSignupRoutingModule,
    SharedModule
  ]
})
export class SigninSignupModule { }
