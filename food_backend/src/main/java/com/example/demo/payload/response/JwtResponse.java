package com.example.demo.payload.response;

import com.example.demo.model.account.Account;
import com.example.demo.model.user.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private Integer id;
    private String token;
    private Collection<? extends GrantedAuthority> roles;
    private String email;
    private Account account;
    private User user;

    public JwtResponse(String token, Collection<? extends GrantedAuthority> roles,
                       Account account, User user) {
        this.token = token;
        this.roles = roles;
        this.account = account;
        this.user = user;
    }

    public JwtResponse() {
    }

    public JwtResponse(Integer id, String token, Collection<? extends GrantedAuthority> roles, String email, Account account, User user) {
        this.id = id;
        this.token = token;
        this.roles = roles;
        this.email = email;
        this.account = account;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
