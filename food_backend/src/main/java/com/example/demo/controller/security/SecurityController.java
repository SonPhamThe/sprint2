package com.example.demo.controller.security;

import com.example.demo.dto.security.JwtResponse;
import com.example.demo.dto.security.MessageResponse;
import com.example.demo.dto.security.SignInForm;
import com.example.demo.model.account.Account;
import com.example.demo.sercurity.jwt.JwtProvider;
import com.example.demo.sercurity.user_detail.MyUserDetail;
import com.example.demo.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/api/auth")
@RestController
public class SecurityController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/signin")
    public ResponseEntity<?> login(@Validated @RequestBody SignInForm signInForm) {


        Account accountValidate = accountService.findAccountByUsername(signInForm.getUsername());

        if (accountValidate == null) {
            return new ResponseEntity<>(new MessageResponse("username not found"), HttpStatus.NOT_FOUND);
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);

        MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(token,
                myUserDetail.getAccount(), myUserDetail.getAccount().getUser(),
                myUserDetail.getAuthorities()));
    }
}
