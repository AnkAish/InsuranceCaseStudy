import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  url ="http://localhost:9119/home/user";

  constructor( private http: HttpClient) { }

  saveUser(data: any):Observable<any>{
    return this.http.post( this.url, data);
  }
}
