import { Component, OnInit } from '@angular/core';
import { OrderDetail } from '../model/order/order_detail';
import { User } from '../model/user/user';
import { TokenService } from '../service/account/token.service';
import { FoodServiceService } from '../service/food/food-service.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit { 
  cartItems: OrderDetail[] =[];
  deliverPrice: number = 10000;
  user: User;
  totalPrice: number = 0;
  constructor(private _tokenService: TokenService,
    private _foodService: FoodServiceService) { }

  ngOnInit(): void {
    this.user = JSON.parse(this._tokenService.getUser())
    this._foodService.getCart(this.user.id).subscribe(data=>{
      this.cartItems = data;
      data.forEach(value=>{
        this.totalPrice += value.quantity * value.food.price;
      })
      console.log(this.totalPrice);
      console.log(this.cartItems);
    })
  }

  calTotalPrice(): number {
    let sum: number = 0;
    // this.cartItems.forEach((item: CartItem) => {
    //   sum += item.foodPrice * item.foodQuantity;
    // })
    return sum;
  }

  removeItem(i: number): void {
    // this.cartItems.forEach((value: CartItem, index: number) => {
    //   if (index == i && value.foodQuantity > 1) {
    //     value.foodQuantity--;
    //     return;
    //   }
    // })
  }

  addItem(i: number): void {
    // this.cartItems.forEach((value: CartItem, index: number) => {
    //   if (index == i) {
    //     value.foodQuantity++;
    //     return;
    //   }
    // })
  }

  deleteItem(id): void {
   this._foodService.deleteOrder(id).subscribe(data=>{
    
   })
  }

}

interface CartItem {
  foodImageLink: string,
  foodName: string,
  foodQuantity: number,
  foodPrice: number
}