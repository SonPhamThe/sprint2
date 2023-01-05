import { User } from "../user/user";
import { AccountRole } from "./account_role";
import { LockAccount } from "./lock_account";
import { PasswordReset } from "./password_reset";

export interface Account {
  id?: number;
  username?: string;
  password?: string;
  user?: User;
  lock_account?: LockAccount;
  account_role?: AccountRole;
  password_reset?: PasswordReset
}