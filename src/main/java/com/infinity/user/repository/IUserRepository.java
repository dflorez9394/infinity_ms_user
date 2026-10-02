package com.infinity.user.repository;

import com.infinity.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserEntity,String> {

    /**
     * JPQL
     * SELECT * FROM USER WHERE name = ? ;
     */
    @Query(
            """
    SELECT u
    FROM UserEntity u
    WHERE u.name = :name

"""
    )
    //and u.lastname = :lastamen
    List<UserEntity> listarPorNombre(
            @Param("name") String name
    );


    List<UserEntity> findByNameAndLastname(String name, String lastname);


    /**
     *  SELECT * FROM user u where u.name like '%valor%'
     */
    List<UserEntity> findByNameContaining(String name);



}