import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NearbyShopsComponent } from './nearby-shops/nearby-shops.component';
import { MyPreferredShopsComponent } from './my-preferred-shops/my-preferred-shops.component';
import {ShopService} from "../service/shop.service";
import {RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";

const appRoutes:Routes=[
  {path:'MyPreferredShops',component:MyPreferredShopsComponent},
  {path:'NearbyShops',component:NearbyShopsComponent},
  {path:'',redirectTo:'/NearbyShops',pathMatch:"full"}
];

@NgModule({
  declarations: [
    AppComponent,
    NearbyShopsComponent,
    MyPreferredShopsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpModule
  ],
  providers: [ShopService],
  bootstrap: [AppComponent]
})
export class AppModule { }
