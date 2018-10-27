import { Injectable } from '@angular/core';
import { Producto } from '../../model/product';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable()
export class ShippingService {

  private subject: BehaviorSubject<Producto[]> = new BehaviorSubject([]);
  private itemsCarrito: Producto[] = [];

  constructor() {
    this.subject.subscribe(data => this.itemsCarrito = data);
   }

  addCarrito(producto: Producto) {
    this.subject.next([...this.itemsCarrito, producto]);
  }

  clearCarrito() {
    this.subject.next(null);
  }

  getCarrito(): Observable<Producto[]> {
    return this.subject;
  }

  getTotal() {
    return this.itemsCarrito
    .reduce(
      (total, producto: Producto) => 
      total + producto.precio, 0);
  }
}
