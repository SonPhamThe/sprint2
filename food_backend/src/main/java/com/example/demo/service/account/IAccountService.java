package com.example.demo.service.account;

import com.example.demo.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountService {
    Account findAccountByUsername(String username);
}
