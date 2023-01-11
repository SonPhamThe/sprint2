package com.example.demo.service.user.impl;

import com.example.demo.repository.model.user.UserType;
import com.example.demo.repository.user.IUserTypeRepository;
import com.example.demo.service.user.IUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService implements IUserTypeService {
    @Autowired
    private IUserTypeRepository userTypeRepository;
    @Override
    public List<UserType> showAllUserType() {
        return userTypeRepository.findAll();
    }
}
