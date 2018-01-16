import { Component, OnInit } from '@angular/core';
import {ShopService} from "../../service/shop.service";
import {Http} from "@angular/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-my-preferred-shops',
  templateUrl: './my-preferred-shops.component.html',
  styleUrls: ['./my-preferred-shops.component.css']
})
export class MyPreferredShopsComponent implements OnInit {

  shops:any;

  constructor(public http:Http,public shopService:ShopService,public router:Router) {
    this.getAllShops();
  }

  ngOnInit() {

  }

  getAllShops(){
    this.shopService.getShopsLiked().subscribe(data=> {
      this.shops= data;
    }, err=> {
      console.log(err);
    })
  }

  removeButton(id:any){
    this.shopService.ShopNoLikeNoDislike(id).subscribe(data=> {
      this.shops= data;
    }, err=> {
      console.log(err);
    })
  }

}
