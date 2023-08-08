import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { ILogin } from 'src/app/models/login/login-model';
import { environment } from 'src/environments/environment.development';
import { ErrorHandlerService } from '../error/error-handler.service';
import { ILoginRegister } from 'src/app/models/login/register/login-model-new';

@Injectable({
  providedIn: 'root',
})
export class LoginService {

  constructor(private httpClient: HttpClient, private errorHandler : ErrorHandlerService) {}

  apiUrl = environment.apiUrl;
  resourceLoginValidate = 'login/validate-login';
  resourceLoginRegister = 'login/register';

  register(register: ILoginRegister):Observable<any>{
    return this.httpClient.post<any>(`${this.apiUrl}${this.resourceLoginRegister}`, register).pipe(catchError(this.errorHandler.handlerError));
  }

  validateLogin(login: ILogin): Observable<ILogin> {
    return this.httpClient.post<ILogin>(`${this.apiUrl}${this.resourceLoginValidate}`,login).pipe(catchError(this.errorHandler.handlerError));
  }
}
