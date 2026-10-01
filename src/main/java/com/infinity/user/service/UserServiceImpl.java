package com.infinity.user.service;

import com.infinity.user.dto.UserDTO;
import com.infinity.user.mapper.UserMapper;
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
    public ResponseEntity<UserEntity> create(UserDTO user) {
       /* UserEntity userDb= new UserEntity();
        userDb.setDocument(user.getDocument());
        userDb.setEmail(user.getEmail());
        userDb.setLastname(user.getLastname());
        userDb.setName(user.getName());*/

        UserEntity userDb=  UserMapper.dtoToEntity(user);

        var newUSer = this.repository.save(userDb);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUSer);
    }
}
