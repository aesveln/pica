import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationsService {
  variable: any;
  private readonly API_URL = 'http://192.168.1.102:8080/salesorder';
  constructor(private http: HttpClient) { }

  getAllOrders(userId:number): Observable<any> {
    this.variable = this.http.get(
      this.API_URL + '/salesorderOpen/'+userId, 
      {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      });
    return this.variable;
   }
   
   deleteOrders(saleId:number): Observable<any> {
    this.variable = this.http.get(
      this.API_URL + '/cancelSaleOrder/'+saleId, 
      {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      });
    return this.variable;
   }
}
