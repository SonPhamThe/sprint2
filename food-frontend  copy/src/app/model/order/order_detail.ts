import { OrderFood } from "./order_food";

export interface OrderDetail {
  id?: number;
  quantity?: number;
  productDetail?: ProductDetail;
  orderFood?: OrderFood;
}