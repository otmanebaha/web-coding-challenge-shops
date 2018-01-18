import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions} from "@angular/http";
import "rxjs/add/operator/map";
import 'rxjs/Rx';

@Injectable()
export class AccountService {
  constructor(public http: Http) {
  }

  saveAccount(account:Account){
    return this.http.post("http://localhost:8080/Account/",account)
      .map(resp=>resp.json());
  }

  findAccount(account:Account){
    return this.http.post("http://localhost:8080/FindAccount/",account)
      .map(resp=>resp.json());
  }

  findByEmail(account:Account){
    return this.http.post("http://localhost:8080/FindByEmail/",account)
      .map(resp=>resp.json());
  }
}
