import { Account } from "./account";

export interface LockAccount {
  id?: number;
  start_day?: string;
  end_day?: string;
  reason?: string;
  account?: Account
}