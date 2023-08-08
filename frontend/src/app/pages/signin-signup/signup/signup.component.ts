import { Component, Injector, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ILoginRegister } from 'src/app/models/login/register/login-model-new';
import { LoginService } from 'src/app/shared/services/login/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  formBuilder: FormBuilder;
  signupForm: FormGroup;

  constructor(
    private loginService: LoginService,
    private router: Router,
    private injector: Injector
  ) {
    this.formBuilder = this.injector.get(FormBuilder);
    this.signupForm = this.formBuilder.group({});
  }

  ngOnInit(): void {
    this.buildSignupForm();
  }

  buildSignupForm() {
    this.signupForm = this.formBuilder.group({
      id: [null],
      usuario: [null, [Validators.required]],
      senha: [null, [Validators.required]],
      pessoa: this.formBuilder.group({
        id: [null],
        nome: [null, [Validators.required]],
        cpf: [null, [Validators.required]],
        idade: [null, [Validators.required]],
        email: [null, [Validators.required]]
      }),
    });
  }

  registerLogin(){
    const loginRegister : ILoginRegister = this.signupForm.value;
    this.loginService.register(loginRegister).subscribe(() => {
      Swal.fire(
        'Sucesso',
        'Login registrado com Sucesso',
        'success'
      )
      this.router.navigate(['']);
    })
  }
}
