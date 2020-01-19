package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.CountryEntity;

import java.util.List;

public interface CountryRepository {
    CountryEntity add(CountryEntity country);
    CountryEntity getById(Long id);
    List<CountryEntity> findAll();
    CountryEntity delete(Long id);
    Long updateLastId();
}
