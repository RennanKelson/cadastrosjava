import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ErrorHandlerService } from '../error/error-handler.service';

@Injectable({
  providedIn: 'root',
})
export class TrainingService {
  constructor(
    private httpClient: HttpClient,
    private errorHandler: ErrorHandlerService
  ) {}
  
}
