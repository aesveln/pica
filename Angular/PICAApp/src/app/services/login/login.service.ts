import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UserRequest } from '../../model/Request/userRequest';
import {Md5} from 'ts-md5/dist/md5';
import { updateUserRequest } from '../../model/Request/createUserRequest';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  updateUser:updateUserRequest;
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
      this.updateUser = new updateUserRequest();
      this.updateUser.firstName = firstName;
      this.updateUser.lastName = lastName;
      this.updateUser.email = email;
      this.updateUser.documentType = documentType;
      this.updateUser.documentNumber = document;
      this.updateUser.pass = Md5.hashStr(password).toString();
      this.updateUser.phoneNumber = phone;
      console.log(Md5.hashStr(password).toString());
      return this.http.post(this.API_URL + '/createCustomer', JSON.stringify(this.updateUser), {
        headers: new HttpHeaders()
        .set('Content-Type', 'application/json')
        });
      }
    
}
