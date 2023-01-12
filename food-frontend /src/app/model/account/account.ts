import { User } from "../user/user";
import { AccountRole } from "./account_role";
export interface Account {
  id?: number;
  username?: string;
  password?: string;
  enabled?: number
}