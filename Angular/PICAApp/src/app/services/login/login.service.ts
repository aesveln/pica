import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UserRequest } from '../../model/Request/userRequest';
import {Md5} from 'ts-md5/dist/md5';
import { CreateUserRequest } from '../../model/Request/createUserRequest';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  createUserRequest:CreateUserRequest;
  userRequest: UserRequest;
  private readonly API_URL = 'http://192.168.1.103:8080/api/users';
  constructor(private http: HttpClient) {}

  userAuthentication(userName, password): Observable<any> {
    console.log(this.API_URL);
    this.userRequest = new UserRequest();
    this.userRequest.correo = userName;
    this.userRequest.password = Md5.hashStr(password).toString();
    console.log(Md5.hashStr(password).toString());
    return this.http.post(this.API_URL + '/login', JSON.stringify(this.userRequest), {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      });
    }

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
