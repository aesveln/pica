import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Producto } from '../../model/product';
import { ProductoRequest } from '../../model/Request/ProductRequest';
import { productos } from '../../model/Pages/productos';
import { debug } from 'util';
import { UrlSchemas } from 'src/app/Tools/Url/UrlSchema';

@Injectable()
export class ProductService {
  variable: any;
  productList:any;
  productListAux:any;
  private productos: Array<Producto> = [];
  private readonly API_URL = UrlSchemas.UrlProducts + 'products';
  private readonly API_URLo = UrlSchemas.UrlOrder + 'orders';
  private readonly _imageServer = UrlSchemas.UrlFileServer;
  private subject: BehaviorSubject<Producto[]> = new BehaviorSubject([]);
  private itemsCarrito: Producto[] = [];

  constructor(private http: HttpClient) {
    this.subject.subscribe(data => this.itemsCarrito = data);
  }

   getAllProductos(productRequest: ProductoRequest): Observable<any> {
    this.variable = this.http.post(
      this.API_URL + '/findAllSpectacleProducts', 
      JSON.stringify(productRequest), {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      });
    return this.variable;
   }

  addCarrito(producto: Producto) {
    this.productList = this.subject;
    let count = 0;
    let existItem = false;
    
    for (let entry of this.productList.value) {
      if(entry.codigo === producto.codigo){
        existItem = true;
      }
    }

    if((this.productList.value.length <= 0 || isNaN(producto.quantity)) && !existItem){
        producto.quantity = 1  
      this.subject.next([...this.itemsCarrito, producto]);
    }else{
      for (let entry of this.productList.value) {
        if(entry.codigo === producto.codigo){
          this.productList.value[count].quantity = this.productList.value[count].quantity + 1; 
          let productListAux = this.productList.value[count];
          this.productList.value.splice( count, 1 );
            this.subject.next([...this.itemsCarrito, productListAux]);
        }
        count++;
      }
      localStorage.setItem('ShoppingCar',JSON.stringify(this.subject.value));
    }
  }

  removeCarrito(producto: Producto) {
    this.productList = this.subject;

    let count = 0;
      for (let entry of this.productList.value) {
        if(entry.codigo === producto.codigo){
          console.log('entramos');

          this.productList.value[count].quantity = this.productList.value[count].quantity - 1; 
          let productListAux = this.productList.value[count];
          this.productList.value.splice( count, 1 );
          if(productListAux.quantity >= 1 ){
            this.subject.next([...this.itemsCarrito, productListAux]);
          }
        }
        count++;
      }
      localStorage.setItem('ShoppingCar',JSON.stringify(this.subject.value));
  }

  clearCarrito() {
    this.subject.next(null);
  }

  getCarrito(): Observable<Producto[]> {
    return this.subject;
  }

  getTotal(producto:Array<Producto>): number{

    return this.itemsCarrito.reduce(
      (total, producto: Producto) => { 
        return total + (producto.quantity * producto.precio); 
      }, 0);
  }
  createOrders(saleId): Observable<any> {
    debugger;
    this.variable = this.http.post(
      this.API_URLo + '/crearOrden',
      JSON.stringify(saleId), 
      {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      });
    return this.variable;
   }
}
