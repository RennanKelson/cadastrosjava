import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ErrorHandlerService } from '../error/error-handler.service';
import { environment } from 'src/environments/environment.development';
import { Observable, catchError } from 'rxjs';
import { IRegisterPerson } from 'src/app/models/login/register/register-person-model';

@Injectable({
  providedIn: 'root',
})
export class PessoaService {
  constructor(
    private httpClient: HttpClient,
    private errorHandler: ErrorHandlerService
  ) {}

  apiUrl = environment.apiUrl + "pessoa/";

  findById(id: number): Observable<IRegisterPerson>{
    return this.httpClient.get<IRegisterPerson>(`${this.apiUrl}${id}`).pipe(catchError(this.errorHandler.handlerError));
  }
}
