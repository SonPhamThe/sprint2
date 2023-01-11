import { Account } from "../account/account";
import { UserType } from "./user_type";

export interface User {
  id?: number
  firstName?: string;
  lastName?: string;
  email?: string;
  phone?: string;
  pointDedication?: number;
  birthDay?: string;
  idCard?: string;
  deleteStatus?: boolean;
  userType?: UserType;
  account?: Account;
}