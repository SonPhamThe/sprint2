import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ppid } from 'process';
import { AboutComponent } from './about/about.component';
import { BookingComponent } from './booking/booking.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';


const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'menu', component:MenuComponent},
  {path: 'about', component:AboutComponent},
  {path: 'booking', component:BookingComponent},
  {path: 'login', component:LoginComponent},
  {path: 'cart', component:CartComponent}
  // {path: 'delete/:id', component: DeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
