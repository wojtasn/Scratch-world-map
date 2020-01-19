package com.example.demo.persistence.repository.impl;

import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Long lastId = 1L;
    public List<UserEntity> userDB = new ArrayList<>();

    @Override
    public UserEntity add(UserEntity user) {
        userDB.add(user);
        return user;
    }

    @Override
    public UserEntity getById(Long id){
        return userDB.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDB;
    }

    @Override
    public UserEntity delete(Long id){
        UserEntity user = getById(id);
        userDB.remove(user);
        return user;
    }

    @Override
    public Long updateLastId() {
        return lastId++;
    }
}
