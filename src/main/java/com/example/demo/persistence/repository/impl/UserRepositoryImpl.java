package com.example.demo.persistence.repository.impl;

import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository {

    public Set<UserEntity> userDB = new HashSet<>();

    public UserEntity add(UserEntity user) {
        userDB.add(user);
        return user;
    }

    public UserEntity getById(Long id){
        return userDB.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public UserEntity delete(Long id){
        UserEntity user = getById(id);
        userDB.remove(user);
        return user;
    }
}
