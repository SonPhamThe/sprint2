package com.example.demo.service.user.impl;

import com.example.demo.model.user.User;
import com.example.demo.repository.user.IUserRepository;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }
}
