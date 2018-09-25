import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from '../../model/product';
import { ProductoRequest } from '../../model/Request/ProductRequest';

@Injectable()
export class ProductService {
  variable: any;
  private productos: Array<Producto> = [];
  private readonly API_URL = 'http://192.168.3.111:8080/api/products';
  private readonly _imageServer = '35.235.105.138:8181'
  constructor(private http: HttpClient) {}

   getAllProductos(productRequest: ProductoRequest): Observable<any> {

    this.variable = this.http.post(this.API_URL + '/findAllSpectacleProducts', JSON.stringify(productRequest), {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      });
      
    console.log(JSON.stringify(this.variable));

    return this.variable;
    }
}
