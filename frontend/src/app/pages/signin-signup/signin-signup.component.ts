import { Component, Injector, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ILogin } from 'src/app/models/login/login-model';
import { LoginService } from 'src/app/shared/services/login/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signin-signup',
  templateUrl: './signin-signup.component.html',
  styleUrls: ['./signin-signup.component.css']
})
export class SigninSignupComponent implements OnInit{

  formBuilder: FormBuilder;
  loginForm: FormGroup;

  constructor(private loginService: LoginService, private router: Router, private injector: Injector){
    this.formBuilder = this.injector.get(FormBuilder);
    this.loginForm = this.formBuilder.group({});
  }

  ngOnInit(): void {
    this.buildLoginForm();
  }

  buildLoginForm(){
    this.loginForm = this.formBuilder.group({
      id: [null],
      usuario: [null, [Validators.required]],
      senha: [null, [Validators.required]]
    });
  }

  validateLogin(){
    const validateLogin: ILogin = this.loginForm.value;
    this.loginService.validateLogin(validateLogin).subscribe((response: ILogin) => {
      if(response.idPessoa){
        localStorage.setItem('idPerson', response.idPessoa.toString())
      }

      Swal.fire(
        'Sucesso',
        'Login Realizado',
        'success'
      )

      this.router.navigate(['/training']);
    })
  }

}
