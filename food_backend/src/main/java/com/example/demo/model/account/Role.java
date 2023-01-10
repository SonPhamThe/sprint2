package com.example.demo.model.account;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;
        @JsonBackReference
        @OneToMany(mappedBy ="role")
        private Set<AccountRole> accountRoles;

        public Role() {
        }

        public Role(Integer id, String name, Set<AccountRole> accountRoles) {
            this.id = id;
            this.name = name;
            this.accountRoles = accountRoles;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<AccountRole> getAccountRoles() {
            return accountRoles;
        }

        public void setAccountRoles(Set<AccountRole> accountRoles) {
            this.accountRoles = accountRoles;
        }
    }
