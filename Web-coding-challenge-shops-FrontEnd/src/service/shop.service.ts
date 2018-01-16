import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions} from "@angular/http";
import "rxjs/add/operator/map";
import 'rxjs/Rx';

@Injectable()
export class ShopService {
  constructor(public http: Http) {
  }

  getShops(){
    return this.http.get("http://localhost:8080/Shops")
      .map(resp=>resp.json());
  }

  getShopsLiked(){
    return this.http.get("http://localhost:8080/MyShops")
      .map(resp=>resp.json());
  }

  ShopLike(id:any){
    return this.http.put("http://localhost:8080/Shops/like",id)
      .map(resp=>resp.json());
  }

  ShopDislike(id:any){
    return this.http.put("http://localhost:8080/Shops/dislike",id)
      .map(resp=>resp.json());
  }

  ShopNoLikeNoDislike(id:any){
    return this.http.put("http://localhost:8080/Shops/noLikeNoDislike",id)
      .map(resp=>resp.json());
  }


}
