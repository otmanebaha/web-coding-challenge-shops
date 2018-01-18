import { Component, OnInit } from '@angular/core';
import {ShopService} from "../../service/shop.service";
import {Http} from "@angular/http";
import {Router} from "@angular/router";
import {NavbarService} from "../../service/navbar.service";

@Component({
  selector: 'app-nearby-shops',
  templateUrl: './nearby-shops.component.html',
  styleUrls: ['./nearby-shops.component.css']
})
export class NearbyShopsComponent implements OnInit {

  shops:any;

  constructor(public http:Http,
              public shopService:ShopService,
              public router:Router,
              public nav:NavbarService) {
    this.getAllShops();
  }

  ngOnInit() {
    this.nav.show();
  }

  getAllShops(){
    this.shopService.getShops().subscribe(data=> {
      this.shops= data;
    }, err=> {
      console.log(err);
    })
  }

  likeButton(id:any){
    this.shopService.ShopLike(id).subscribe(data=> {
      this.shops= data;
    }, err=> {
      console.log(err);
    })
  }

  dislikeButton(id:any){
    this.shopService.ShopDislike(id).subscribe(data=> {
      this.shops= data;
    }, err=> {
      console.log(err);
    })
  }

}
