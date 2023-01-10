package com.example.demo.service.user;

import com.example.demo.model.food.Food;
import com.example.demo.model.user.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> listUser();

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User save(User user);
}
