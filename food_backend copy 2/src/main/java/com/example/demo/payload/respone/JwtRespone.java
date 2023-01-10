package com.example.demo.payload.respone;

import com.example.demo.model.account.Account;
import com.example.demo.model.user.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtRespone {
    private Integer id;
    private String token;
    private Collection<? extends GrantedAuthority> roles;
    private String email;
    private Account account;
    private User user;

    public JwtRespone(String token, Collection<? extends GrantedAuthority> roles,
                      Account account, User user) {
        this.token = token;
        this.roles = roles;
        this.account = account;
        this.user = user;
    }
}
