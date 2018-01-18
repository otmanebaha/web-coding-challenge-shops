import { Component, OnInit } from '@angular/core';
import {AccountService} from "../../service/account.service";
import {Account} from "../../model/account.model";
import {Router} from"@angular/router";
import {NavbarService} from "../../service/navbar.service";


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  account:Account=new Account();

  constructor(public accountService:AccountService,
              public router:Router,
              public nav:NavbarService) { }

  ngOnInit() {
    this.nav.hide();
  }
  saveAccount(){
    if(this.account.email==null||this.account.password==null){
          alert("one or both of the text fields are empty");
      this.router.navigate(['SignUp']);
    }else {
      this.accountService.findByEmail(this.account)
        .subscribe(data => {
          if (data == true) {
            alert("This account exist !");
          } else {
            this.accountService.saveAccount(this.account)
              .subscribe(data => {
                this.account = data;
                this.router.navigate(['SignIn']);
              }, err => {
                console.log(err);
              })
          }
        })
    }
  }
}
