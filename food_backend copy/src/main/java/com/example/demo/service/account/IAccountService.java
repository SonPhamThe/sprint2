package com.example.demo.service.account;

import com.example.demo.repository.model.account.Account;

public interface IAccountService {
    Account findAccountByUsername(String username);
}
