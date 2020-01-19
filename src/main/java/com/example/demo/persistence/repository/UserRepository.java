package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    UserEntity add(UserEntity user);
    UserEntity getById(Long id);
    List<UserEntity> findAll();
    UserEntity delete(Long id);
    Long updateLastId();
}
