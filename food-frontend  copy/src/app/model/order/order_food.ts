import { Payment } from "../payment/paymen";
import { User } from "../user/user";

export interface OrderFood {
  id?: number;
  user?: User;
  payment?: Payment;
  deleteStatus?: number;
}