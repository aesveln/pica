import { Component, OnInit } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { UserInfo } from 'src/app/model/userInfo';

export class HelperUserInfo  implements OnInit {

    private userInfo: UserInfo;
    tokenInfo: any;

    constructor() { }
  
    ngOnInit() {
    }

    setUserInformation(tokenKey: UserInfo){
        localStorage.setItem('userToken', JSON.stringify(tokenKey));
    }

    getUserInformation(){
        var accessToken = localStorage.getItem('userToken');
        return accessToken!= null ? this.getDecodedAccessToken(accessToken) : null; 
    }

    getDecodedAccessToken(token: string): any {
        this.userInfo = new UserInfo();
        const helper = new JwtHelperService();
        this.userInfo = helper.decodeToken(token);
        const expirationDate = helper.getTokenExpirationDate(token);
        const isExpired = helper.isTokenExpired(token);

        return this.userInfo;
      }
}