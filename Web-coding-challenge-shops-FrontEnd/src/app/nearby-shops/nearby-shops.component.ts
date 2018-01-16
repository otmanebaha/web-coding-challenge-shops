import { Component, OnInit } from '@angular/core';
import {ShopService} from "../../service/shop.service";
import {Http} from "@angular/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-nearby-shops',
  templateUrl: './nearby-shops.component.html',
  styleUrls: ['./nearby-shops.component.css']
})
export class NearbyShopsComponent implements OnInit {

  shops:any;

  constructor(public http:Http,public shopService:ShopService,public router:Router) {
    this.getAllShops();
  }

  ngOnInit() {
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
