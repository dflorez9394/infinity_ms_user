package com.infinity.user.repository;

import com.infinity.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity,String> {
}