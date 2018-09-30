import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { Router } from '@angular/router';
import { ProductoRequest } from '../../model/Request/ProductRequest';
import { ProductService } from '../../services/product/product.service';
import { productos } from '../../model/Pages/productos';
import { Producto } from '../../model/product';
import { Subscription, Observable } from 'rxjs';
import { DtoProduct } from '../../model/Dto/Products/DtoProduct';
import { JwtHelperService } from '@auth0/angular-jwt';
import { JWT } from '../../model/JWT';
import { UserInfo } from '../../model/userInfo';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  [x: string]: any;
  user:UserInfo;
  items: Array<any> = [];
  viewCatalog: boolean;
  values = '';
  product: ProductoRequest;
  productsList: productos;
  showMePartially = false;
  listsProd: Array<DtoProduct> = [];
  showVar = false;
  isAddComplete=false;
  isRemoveComplete = false;
  prod:Producto;
  jwt:JWT;
  shopping:Array<Producto> = [];
  carrito: Array<Producto> = [];
  private subscription: Subscription;
  private total: any;
  isLogged = false;
  constructor(
    private productService: ProductService,
    private router:Router
  ) {
    this.items = [
      {name:  '../../../assets/images/img_mountains_wide.jpg'}
    ];
  }

  ngOnInit() {
    debugger;
    this.jwt =  JSON.parse(localStorage.getItem('userToken'));
    console.log(this.jwt.token);
    this.getDecodedAccessToken(this.jwt.token)
    if(this.jwt.token == null){
      this.router.navigate(['/login']);
    }
    if(this.jwt.token != "null")
    {
      this.isLogged = true;
    }
    else{
      this.isLogged = false;
    }
  }

  typeSearch(event: any) {
    if (event.target.value.length > 0) {
      this.viewCatalog = true;
    } else {
      this.viewCatalog = false;
    }
  }

  toggleChild() {

    this.showVar = !this.showVar;
    this.showMePartially = !this.showMePartially;
    var shopping = JSON.parse(localStorage.getItem('ShoppingCar'));
    this.productService.getCarrito().subscribe(data => {
      this.carrito = data
      this.total = this.productService.getTotal(this.carrito);
      },error => alert(error));
  }

  addProducto(titulo,codigo,precio,quantity) {
    this.prod = new Producto();
    this.prod.codigo = titulo.cod || codigo;
    this.prod.precio = titulo.cost || precio;
    this.prod.titulo = titulo.name || titulo;
    this.prod.quantity = quantity;
    var result = this.productService.addCarrito(this.prod);
    this.isAddComplete=true;
  }
  
  CreateOrden(carrito){
    debugger;
    var key = localStorage.getItem('userToken');
    
    if(key == null){
      this.router.navigate(['/login']);
    }
    
    let carritoArray = carrito;
  }

  removeProducto(titulo,codigo,precio,quantity) {
    this.prod = new Producto();
    this.prod.codigo = codigo;
    this.prod.precio = precio;
    this.prod.titulo = titulo;
    this.prod.quantity = quantity;
    this.productService.removeCarrito(this.prod);
    this.isAddComplete=true;
  }

  getEventsFilter(){
        this.product = new ProductoRequest();
        this.productsList = new productos();
        this.listsProd = new Array();
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
            //  console.log(JSON.stringify(data));
             this.productsList = data.productos;
             this.listsProd = this.productsList.content;
             if (this.listsProd.length > 0) {
              this.viewCatalog = true;
            } else {
              this.viewCatalog = false;
            }
            },
            error => {
              console.log(error);
            }
          )
      }

      getDecodedAccessToken(token: string): any {
        
        this.user = new UserInfo();
        debugger;
        const helper = new JwtHelperService();
        this.user = helper.decodeToken(token);
        // Other functions
        const expirationDate = helper.getTokenExpirationDate(token);
        const isExpired = helper.isTokenExpired(token);
      }

}
