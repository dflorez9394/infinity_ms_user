package com.infinity.user.controller;

import com.infinity.user.controller.doc.IUserDoc;
import com.infinity.user.dto.UserDTO;
import com.infinity.user.model.UserEntity;
import com.infinity.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Override
    @GetMapping("/names")
    public ResponseEntity<?> listByName(String name) {
        return this.service.getAllPorNombre(name);
    }

    @Override
    @GetMapping("/name/concidents")
    public ResponseEntity<?> listByNameConsidents(String name) {
        return this.service.getNameConsidents(name);
    }
}
