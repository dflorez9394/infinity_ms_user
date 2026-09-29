package com.infinity.user.controller;

import com.infinity.user.model.UserEntity;
import com.infinity.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final IUserService service;

    @PostMapping
    public ResponseEntity<UserEntity> create(
            @RequestBody UserEntity user
    ){
        return this.service.create(user);
    }
}
