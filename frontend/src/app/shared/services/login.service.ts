import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ILogin } from 'src/app/models/login/login-model';
import { IRegisterPerson } from 'src/app/models/login/register/register-person-model';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private httpClient: HttpClient) {}

  apiUrl = environment.apiUrl;
  resourceLoginValidate = 'login/validate-login';
  resourceLoginRegister = 'register';

  register(register: IRegisterPerson):Observable<any>{
    return this.httpClient.post<any>(`${this.apiUrl}${this.resourceLoginRegister}`, register);
  }

  validateLogin(login: ILogin): Observable<ILogin> {
    return this.httpClient.post<ILogin>(
      `${this.apiUrl}${this.resourceLoginValidate}`,
      login
    );
  }
}
