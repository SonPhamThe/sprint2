package com.example.demo.service.account;

import com.example.demo.model.account.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getListRoleByAccountId(Integer accountId);
}
