import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Subscription } from 'rxjs';

import { ProductService } from '../../services/product/product.service';
import { Producto } from '../../model/product';
import { ShippingService } from '../../services/shipping/shipping.service';
import { productos } from '../../model/Pages/productos';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  @Output() emitEvent:EventEmitter<productos> = new EventEmitter<productos>();
  showVar = false;
  private producto: any;
  private subscription: Subscription;
  private productos: Array<any> = [];


  constructor() { }

  ngOnInit() {
  }

  toggleChild() {
    this.showVar = !this.showVar;
  }

  DrawData(data){
    debugger;
    console.log('llegamos al componente hijo');
    console.log(data);
  }
  // getCatalogo() {
  //   this.productService.getProductos()
  //     .then(data => {
  //       this.productos = (data as Array<Producto>).filter(x => x.novedad !== true);
  //     })
  //     .catch(error => alert(error));
  // }

  // /**
  //  * addProducto
  //  */
  // addProducto(producto) {
  //   this.shippingService.addCarrito(producto);
  // }


}
