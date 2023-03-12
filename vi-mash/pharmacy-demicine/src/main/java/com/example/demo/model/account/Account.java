package com.example.demo.model.account;

import com.example.demo.model.user.User;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private Integer enable;

    @OneToOne(mappedBy = "account")
    private User user;

    @OneToMany(mappedBy = "account")
    private Set<AccountRole> accountRoles;

    public Account() {
    }

    public Account(Integer id, String username, String password, Integer enable, User user, Set<AccountRole> accountRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.user = user;
        this.accountRoles = accountRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(Set<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }
}
