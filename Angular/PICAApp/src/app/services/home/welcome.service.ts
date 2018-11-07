import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ElasticRequest } from '../../model/Request/ElasticSearch/elasticRequest';
import { Observable } from 'rxjs';
import { UrlSchemas } from 'src/app/Tools/Url/UrlSchema';

@Injectable({
  providedIn: 'root'
})
export class WelcomeService {
  private readonly API_URL = UrlSchemas.UrlElastic + '/productos/producto';
  private readonly API_URL_Top = UrlSchemas.UrlOrder + 'orders';
  variable: any;
  constructor(private http: HttpClient) { }

  elasticSearch(elasticRequest: ElasticRequest): Observable<any> {
    console.log(JSON.stringify(elasticRequest));
    this.variable = this.http.post(
      this.API_URL + '/_search', 
      JSON.stringify(elasticRequest), {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      });
    return this.variable;
   }
   
   topProducts(topProduct): Observable<any> {
    this.variable = this.http.get(
      this.API_URL_Top + '/topProductos/'+topProduct, 
      {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      });
    return this.variable;
   }

}
