import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SigninSignupComponent } from './pages/signin-signup/signin-signup.component';
import { ErrorComponent } from './handlers/error/error.component';
import { SharedModule } from './shared/shared.module';
import { TrainingComponent } from './pages/training/training.component';

@NgModule({
  declarations: [
    AppComponent,
    SigninSignupComponent,
    ErrorComponent,
    TrainingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
