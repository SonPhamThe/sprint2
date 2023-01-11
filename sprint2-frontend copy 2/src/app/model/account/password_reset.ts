import { Account } from "./account";

export interface PasswordReset {
  id?: number;
  token?: string;
  expiryDate?: string;
  account?: Account
}