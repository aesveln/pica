import { Component, OnInit } from '@angular/core';
import { ProductoRequest } from '../../model/Request/ProductRequest';
import { ProductService } from '../../services/product/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  items: Array<any> = [];
  viewCatalog: boolean;
  values = '';
  product: ProductoRequest;
  constructor(
    private productService: ProductService
  ) {
    this.items = [
      {name:  '../../../assets/images/img_mountains_wide.jpg'}
    ];
  }

  ngOnInit() {
  }

  typeSearch(event: any) {
    if (event.target.value.length > 0) {
      this.viewCatalog = true;
    } else {
      this.viewCatalog = false;
    }
  }

  getEventsFilter(){
    debugger;
        this.product = new ProductoRequest();
    
        this.product.arrivalDate = '';
        this.product.departureDate = '';
        this.product.pageNumber = 0;
        this.product.pageSize = 10
        this.product.return_date = '';
        this.product.sortBy = '';
        this.product.spectacleDate = '';
    
        this.productService.getAllProductos(this.product)
          .subscribe(
            (data)=> {
              JSON.stringify(data)
            },
            error => {
              console.log(error);
            }
          )
      }
}
