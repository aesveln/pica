import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ElasticRequest } from '../../model/Request/ElasticSearch/elasticRequest';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WelcomeService {
  private readonly API_URL = 'http://192.168.1.103:9200/productos/producto';
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
}
