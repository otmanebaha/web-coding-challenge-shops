import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NearbyShopsComponent } from './nearby-shops/nearby-shops.component';
import { MyPreferredShopsComponent } from './my-preferred-shops/my-preferred-shops.component';
import {ShopService} from "../service/shop.service";
import {RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import {AccountService} from "../service/account.service";
import {NavbarService} from "../service/navbar.service";

const appRoutes:Routes=[
  {path:'MyPreferredShops',component:MyPreferredShopsComponent},
  {path:'NearbyShops',component:NearbyShopsComponent},
  {path:'SignUp',component:SignUpComponent},
  {path:'SignIn',component:SignInComponent},
  {path:'',redirectTo:'/SignIn',pathMatch:"full"}
];

@NgModule({
  declarations: [
    AppComponent,
    NearbyShopsComponent,
    MyPreferredShopsComponent,
    SignInComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpModule
  ],
  providers: [ShopService,AccountService,NavbarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
