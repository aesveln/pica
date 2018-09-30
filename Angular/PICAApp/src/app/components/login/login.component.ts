import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login/login.service';
import { JWT } from '../../model/JWT';
import { JwtHelperService } from '@auth0/angular-jwt';
import { UserInfo } from '../../model/userInfo';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLoginError: boolean;
  jwt:JWT;
  @Output() emitEvent:EventEmitter<UserInfo> = new EventEmitter<UserInfo>();
  userInfo:UserInfo;

  constructor( private loginService: LoginService,
    public router: Router) { }

  ngOnInit() {
  }

  LoginOn(userName, password) {

    if(userName != "" && password != "")
    {
      this.jwt = new JWT();
      debugger;
      this.loginService.userAuthentication(userName, password)
        .subscribe(
          (data) => {
            localStorage.setItem('userToken', JSON.stringify(data));
            if(data!=null){
              this.router.navigate(['/home']);
            }
          },
          error => {
            console.log(error);
              this.isLoginError = true;
          });
    }
  }
  createUser(firstName, lastName, documentType, document, 
            phone, email, password, rePassword){
              this.loginService.userCreate(firstName, lastName, documentType, document, 
                phone, email, password, rePassword)
                .subscribe(
                  (data) => {
                    if(data!=null){
                      this.router.navigate(['/login']);
                    }
                  },
                  error => {
                    console.log(error);
                      this.isLoginError = true;
                  });
    }
}
