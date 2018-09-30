import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Md5 } from 'ts-md5';
import { UpdateUserRequest } from '../../model/Request/updateUserRequest';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  [x: string]: any;
  updateUserRequest:UpdateUserRequest;
  private readonly API_URL = 'http://192.168.1.103:8080/api/users';
  
  constructor(private http: HttpClient) { }
  updateCreate(id,firstName, lastName, documentType, document, 
    phone, email, password,cardType, numberCard): Observable<any> {
    console.log(this.API_URL);
    this.updateUser = new UpdateUserRequest();
    this.updateUser.firstName = firstName;
    this.updateUser.lastName = lastName;
    this.updateUser.email = email;
    this.updateUser.documentType = documentType;
    this.updateUser.documentNumber = document;
    this.updateUser.pass = Md5.hashStr(password).toString();
    this.updateUser.phoneNumber = phone;
    this.updateUser.creditcard_type = cardType;
    this.updateUser.creditcard_number = Md5.hashStr(numberCard).toString();
    this.updateUser.id = id;

    console.log(Md5.hashStr(password).toString());
    return this.http.post(this.API_URL + '/updateCustomer', JSON.stringify(this.updateUser), {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      });
    }
}
