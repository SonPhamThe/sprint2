import { Food } from "../food/food";
import { Payment } from "../payment/paymen";
import { UserType } from "./user_type";

export interface User {
  id?: number;
  first_name?: string;
  last_name?: string;
  email?: string;
  phone?: string;
  pointDedication?: number;
  birthDay?: string;
  id_card?: string;
  avatar?: string;
  address?: string;
  food?: Food;
  payment?: Payment
  user_type?: UserType
}