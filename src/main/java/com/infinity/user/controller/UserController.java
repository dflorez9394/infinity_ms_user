package com.infinity.user.controller;

import com.infinity.user.controller.doc.IUserDoc;
import com.infinity.user.dto.UserDTO;
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
public class UserController implements IUserDoc {

    private final IUserService service;

    @PostMapping
    public ResponseEntity<UserEntity> create(
            @RequestBody UserDTO user
    ){
        return this.service.create(user);
    }
}
