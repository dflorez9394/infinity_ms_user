package com.infinity.user.service;

import com.infinity.user.dto.UserDTO;
import com.infinity.user.mapper.UserMapper;
import com.infinity.user.model.UserEntity;
import com.infinity.user.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public ResponseEntity<List<UserDTO>> getAllPorNombre(String nombre) {
        var users =  repository.listarPorNombre(nombre);
        List<UserDTO>  usersList = new ArrayList<>();
        for (UserEntity user :  users){
            usersList.add(
                    UserMapper.entityToDto(user)
            );
        }
        return ResponseEntity.ok(usersList);
    }

    @Override
    public ResponseEntity<List<UserDTO>> getNameConsidents(String name) {
        //Strems
        var users =  repository
                .findByNameContaining(name)
                .stream()
                .map(UserMapper::entityToDto)
                .toList();

        return ResponseEntity.ok(users);
    }
}
