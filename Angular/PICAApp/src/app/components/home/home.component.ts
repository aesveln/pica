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
import { WelcomeService } from '../../services/home/welcome.service';
import { ElasticRequest } from '../../model/Request/ElasticSearch/elasticRequest';
import { debug } from 'util';
import { Query_string } from '../../model/Request/ElasticSearch/query_string';
import { Query } from '../../model/Request/ElasticSearch/query';
import { ElasticResponse } from '../../model/Response/elasticResponse';
import { forEach } from '@angular/router/src/utils/collection';

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
  elastiSer: ElasticRequest;
  query_strings:Query_string;
  query:Query;

  elasticResponse:ElasticResponse;

  private subscription: Subscription;
  private total: any;
  isLogged = false;
  constructor(
    private productService: ProductService,
    private router:Router,
    private welcomeService: WelcomeService
  ) {
    this.items = [
      {name:  '../../../assets/images/img_mountains_wide.jpg'}
    ];
  }

  ngOnInit() {
    
    this.jwt =  JSON.parse(localStorage.getItem('userToken'));
    
    // if(this.jwt == null){
    //   this.router.navigate(['/login']);
    // }
    if(this.jwt != null && this.jwt.token != "null")
    {
      console.log(this.jwt.token);
      this.getDecodedAccessToken(this.jwt.token)
      this.isLogged = true;
    }
    else{
      this.isLogged = false;
    }
  }

  typeSearch(event: any, textSearch) {
    if (event.target.value.length > 0) {
      this.viewCatalog = true;
      this.elastiSer =new ElasticRequest();
      this.query_strings = new Query_string();
      this.query = new Query();

      this.elastiSer.query = this.query;
      this.elastiSer.from = 0;
      this.elastiSer.size = 21;
      this.query.query_string = this.query_strings;
      this.query_strings.query = '*'+textSearch+'*';
      this.query_strings.fields = ["cod","name","description"]
      this.listsProd = new Array<DtoProduct>();
      this.welcomeService.elasticSearch(this.elastiSer).subscribe(data => {
        this.elasticResponse = data;
        let count = 0;
        for (let variableHits of this.elasticResponse.hits.hits) {
          console.log(variableHits);
          let dtProducts = new DtoProduct();
          dtProducts.cod = variableHits._source.cod;
          dtProducts.cost = variableHits._source.cost;
          dtProducts.id = variableHits._id;
          dtProducts.imageRef = variableHits._source.image_ref;
          dtProducts.name = variableHits._source.name; 
          dtProducts.description = variableHits._source.description; 
          this.listsProd[count] = dtProducts;
          count++;
        }
        },error => alert(error));

    } else if(event.target.value.length < 1) {
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
        this.product.pageSize = 9;
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
        const helper = new JwtHelperService();
        this.user = helper.decodeToken(token);
        // Other functions
        const expirationDate = helper.getTokenExpirationDate(token);
        const isExpired = helper.isTokenExpired(token);
      }

}
