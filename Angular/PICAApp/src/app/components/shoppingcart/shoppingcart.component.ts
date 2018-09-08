import { Component, OnInit, Input } from '@angular/core';
import { Producto } from '../../model/product';
import { Subscription } from 'rxjs';
import { ShippingService } from '../../services/shipping/shipping.service';

@Component({
  selector: 'app-shoppingcart',
  templateUrl: './shoppingcart.component.html',
  styleUrls: ['./shoppingcart.component.css']
})
export class ShoppingcartComponent implements OnInit {

  @Input() showMePartially: boolean;
  private carrito: Array<Producto> = [];
  private subscription: Subscription;
  private total: number;

  constructor() {}//private shippingservices: ShippingService) { }

  ngOnInit() {
    // this.shippingservices.getCarrito().subscribe(data => {
    //   console.log(data);
    //   this.carrito = data;
    //   this.total = this.shippingservices.getTotal();
    // },
    //   error => alert(error));
  }

}
