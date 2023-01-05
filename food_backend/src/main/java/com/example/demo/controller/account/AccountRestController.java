package com.example.demo.controller.account;

import com.example.demo.service.account.IAccountService;
import com.example.demo.service.account.impl.PasswordResetTokenService;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountRestController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private PasswordResetTokenService passwordResetTokenUtil;

    @Autowired
    private IUserService userService;
}
