package com.infinity.user.service;

import com.infinity.user.dto.UserDTO;
import com.infinity.user.model.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    ResponseEntity<UserEntity> create(UserDTO user);

    ResponseEntity<List<UserDTO>> getAllPorNombre(String nombre);

    ResponseEntity<List<UserDTO>> getNameConsidents(String name);
}
