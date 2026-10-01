package com.infinity.user.mapper;

import com.infinity.user.dto.UserDTO;
import com.infinity.user.model.UserEntity;

public class UserMapper {

    public static UserEntity dtoToEntity(UserDTO userDTO){
        return UserEntity.builder()
                .document(userDTO.getDocument())
                .email(userDTO.getEmail())
                .lastname(userDTO.getLastname())
                .name(userDTO.getName())
                .build();
    }

}
