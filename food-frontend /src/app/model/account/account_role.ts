import { Account } from "./account";
import { Role } from "./role";

export interface AccountRole {
  id?: number;
  role?: Role;
  account?: Account  
}