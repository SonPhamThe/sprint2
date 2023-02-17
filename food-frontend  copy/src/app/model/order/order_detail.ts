import { Food } from "../food/food";
import { OrderFood } from "./order_food";

export interface OrderDetail {
  id?: number;
  quantity?: number;
  food?: Food,
  orderFood?: OrderFood;
}