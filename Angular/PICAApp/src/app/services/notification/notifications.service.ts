import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { UrlSchemas } from 'src/app/Tools/Url/UrlSchema';

@Injectable({
  providedIn: 'root'
})
export class NotificationsService {
  variable: any;
  private readonly API_URL = UrlSchemas.UrlOrder + 'salesorder';
  
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
