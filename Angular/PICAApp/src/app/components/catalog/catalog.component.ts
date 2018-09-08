import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

import { ProductService } from '../../services/product/product.service';
import { Producto } from '../../model/product';
import { ShippingService } from '../../services/shipping/shipping.service';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
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
