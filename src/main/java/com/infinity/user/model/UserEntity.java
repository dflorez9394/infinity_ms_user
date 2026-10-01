package com.infinity.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @UuidGenerator
    private String id;

    private String document;

    private  String name;

    private String lastname;

    private String email;

    /*@PrePersist
    public void generateId(){

        if(this.id == null){
            this.id = java.util.UUID.randomUUID().toString();
        }
    }*/

}