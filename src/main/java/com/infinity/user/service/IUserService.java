package com.infinity.user.service;

import com.infinity.user.dto.UserDTO;
import com.infinity.user.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity<UserEntity> create(UserDTO user);
}
