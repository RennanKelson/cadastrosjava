import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlerService {

  constructor() { }

  handlerError(error : any): Observable<any>{
    console.log('Algum Error Ocorreu => ', error);
    Swal.fire('', `${error.error.error}, Status ${error.error.status}, Path: ${error.error.path}`, 'error');
    return throwError(() => error);
  }
}
