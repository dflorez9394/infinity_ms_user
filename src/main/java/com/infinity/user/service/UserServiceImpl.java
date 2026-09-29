package com.infinity.user.service;

import com.infinity.user.model.UserEntity;
import com.infinity.user.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private final IUserRepository repository;


    @Override
    public ResponseEntity<UserEntity> create(UserEntity user) {

        var newUSer = this.repository.save(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUSer);
    }

}
