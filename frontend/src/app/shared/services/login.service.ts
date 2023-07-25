import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ILogin } from 'src/app/models/login/login-model';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private httpClient: HttpClient) {}

  apiUrl = environment.apiUrl;
  resourceLoginValidate = 'login/validate-login';

  validateLogin(login: ILogin): Observable<ILogin>{
    return this.httpClient.post<ILogin>(`${this.apiUrl}${this.resourceLoginValidate}`, login);
  }
}
