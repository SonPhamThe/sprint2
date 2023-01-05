package com.example.demo.controller.user;

import com.example.demo.service.user.IUserService;
import com.example.demo.service.user.IUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IUserTypeService userTypeService;
}
