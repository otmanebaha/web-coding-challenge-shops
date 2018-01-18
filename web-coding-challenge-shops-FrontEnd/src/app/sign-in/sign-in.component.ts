import { Component, OnInit } from '@angular/core';
import {AccountService} from "../../service/account.service";
import {Account} from "../../model/account.model";
import {Router} from"@angular/router";
import {NavbarService} from "../../service/navbar.service";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
	account:Account=new Account();
  constructor(public router:Router,
              public accountService:AccountService,
              public nav:NavbarService) { }

  ngOnInit() {
    this.nav.hide();
  }

  Login() {
    this.accountService.findAccount(this.account)
    .subscribe(data=>{
    if(data==true){
    this.router.navigate(['NearbyShops']);
    }
  else{
    alert("This account does not exist");
  }
  })
  }

}
