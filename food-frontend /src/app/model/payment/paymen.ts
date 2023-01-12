import { Food } from "../food/food";

export interface Payment {
  id?: number;
  shippingDescription?: string;
  quantity?: number;
  food?: Food
}