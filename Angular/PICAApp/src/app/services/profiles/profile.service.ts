import { Injectable } from '@angular/core';
import { CreateUserRequest } from '../../model/Request/createUserRequest';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Md5 } from 'ts-md5';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  [x: string]: any;
  createUserRequest:CreateUserRequest;
  private readonly API_URL = 'http://192.168.1.103:8080/api/users';
  
  constructor() { }

  userCreate(firstName, lastName, documentType, document, 
    phone, email, password, rePassword): Observable<any> {
    console.log(this.API_URL);
    this.createUserRequest = new CreateUserRequest();
    this.createUserRequest.firstName = firstName;
    this.createUserRequest.lastName = lastName;
    this.createUserRequest.email = email;
    this.createUserRequest.documentType = documentType;
    this.createUserRequest.documentNumber = document;
    this.createUserRequest.pass = Md5.hashStr(password).toString();
    this.createUserRequest.phoneNumber = phone;
    console.log(Md5.hashStr(password).toString());
    return this.http.post(this.API_URL + '/createCustomer', JSON.stringify(this.createUserRequest), {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      });
    }
}
