import { Component, OnInit } from '@angular/core';
import { NotificationsService } from '../../services/notification/notifications.service';
import { UserInfo } from '../../model/userInfo';
import { JwtHelperService } from '@auth0/angular-jwt';
import { JWT } from '../../model/JWT';
import { orderItems } from '../../model/Dto/Sales/Dtoorders';
import { Sales } from '../../model/Dto/Sales/Dtosales';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  registerServices: object[];
  registerCount: number;
  paginator: boolean;
  user:UserInfo;
  jwt:JWT;
  orderItems:Array<Sales>;
  constructor(private notificationServices:NotificationsService) {
   
  }

  ngOnInit() { 
    this.orderItems = new Array<Sales>();
    this.jwt = new JWT();
    debugger;
    this.jwt.token = localStorage.getItem('userToken');
    if(this.jwt != null && this.jwt.token != "null")
    {
      debugger;
      this.getDecodedAccessToken(this.jwt.token)
      this.notificationServices.getAllOrders(this.user.idCustomer)
      .subscribe(data => {
        debugger;
        this.orderItems = data.sales;
      },error => alert(error));
    }
   
  }

removeOrder(idSales){
  debugger;
  this.notificationServices.deleteOrders(idSales)
      .subscribe(data => {
        debugger;
      },error => alert(error));
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
