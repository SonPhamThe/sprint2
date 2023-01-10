package com.example.demo.service.account.impl;

import com.example.demo.model.account.Role;
import com.example.demo.repository.account.IRoleRepository;
import com.example.demo.service.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<Role> getListRoleByAccountId(Integer accountId) {
        return roleRepository.getListRoleByAccountId(accountId);
    }
}
