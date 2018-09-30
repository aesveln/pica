import { Component, OnInit, Inject } from '@angular/core';
import { UserInfo } from '../../model/userInfo';
import { JwtHelperService } from '@auth0/angular-jwt';
import { JWT } from '../../model/JWT';
import { ProfileService } from 'src/app/services/profiles/profile.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  isLoginError: boolean;
  user:UserInfo;
  jwt:JWT;
  constructor(private profileService:ProfileService,
    private router:Router) {}
  ngOnInit() {
    this.jwt = JSON.parse(localStorage.getItem('userToken'));
    this.getDecodedAccessToken(this.jwt.token);
  }

  updateUser(id,firstName, lastName, documentType, document, 
    phone, email, password, rePassword,cardType, numberCard){
      this.profileService.updateCreate(id, firstName, lastName, documentType, document, 
        phone, email, password, cardType, numberCard)
        .subscribe(
          (data) => {
            if(data!=null){
              this.router.navigate(['/profile']);
            }
          },
          error => {
            console.log(error);
              this.isLoginError = true;
          });
}

openForm()
{
   this.jwt = JSON.parse(localStorage.getItem('userToken'));
    this.getDecodedAccessToken(this.jwt.token);
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

