import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  cartItems: CartItem[] = [
    {
      foodImageLink: 'https://static.kfcvietnam.com.vn/images/items/lg/2-lava-taro.jpg?v=LZKWE4',
      foodName: '2 Viên Khoai Môn Kim Sa',
      foodQuantity: 2,
      foodPrice: 52000
    },
    {
      foodImageLink: 'https://static.kfcvietnam.com.vn/images/items/lg/pumcheese-2thanh.jpg?v=LZKWE4',
      foodName: '2 Thanh Bí Phô Mai',
      foodQuantity: 2,
      foodPrice: 29000
    },
    {
      foodImageLink: 'https://static.kfcvietnam.com.vn/images/items/lg/3-tatsutaage.jpg?v=LZKWE4',
      foodName: '3 Gà Tatsutaage',
      foodQuantity: 1,
      foodPrice: 35000
    },
    {
      foodImageLink: 'https://static.kfcvietnam.com.vn/images/items/lg/4-eggtart.jpg?v=LZKWE4',
      foodName: '4 Bánh Trứng',
      foodQuantity: 1,
      foodPrice: 59000
    }
  ];
  deliverPrice: number = 10000;
  constructor() { }

  ngOnInit(): void {
  }

  calTotalPrice(): number {
    let sum: number = 0;
    this.cartItems.forEach((item: CartItem) => {
      sum += item.foodPrice * item.foodQuantity;
    })
    return sum;
  }

  removeItem(i: number): void {
    this.cartItems.forEach((value: CartItem, index: number) => {
      if (index == i && value.foodQuantity > 1) {
        value.foodQuantity--;
        return;
      }
    })
  }

  addItem(i: number): void {
    this.cartItems.forEach((value: CartItem, index: number) => {
      if (index == i) {
        value.foodQuantity++;
        return;
      }
    })
  }

  deleteItem(i: number): void {
    this.cartItems.splice(i, 1);
  }

}

interface CartItem {
  foodImageLink: string,
  foodName: string,
  foodQuantity: number,
  foodPrice: number
}