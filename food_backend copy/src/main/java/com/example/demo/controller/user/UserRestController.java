package com.example.demo.controller.user;

import com.example.demo.model.user.User;
import com.example.demo.model.user.UserType;
import com.example.demo.service.user.IUserService;
import com.example.demo.service.user.IUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IUserTypeService userTypeService;

    @GetMapping("")
    public ResponseEntity<List<User>> findAllUser() {
        List<User> userList = userService.listUser();
        if(userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @GetMapping("/userType")
    public ResponseEntity<List<UserType>> findAllUserType() {
        List<UserType> userTypes = userTypeService.showAllUserType();
        if(userTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserType>>(userTypes, HttpStatus.OK);
    }
}
