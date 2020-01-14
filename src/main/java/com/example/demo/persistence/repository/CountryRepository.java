package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.CountryEntity;

import java.util.Set;

public interface CountryRepository {

    public CountryEntity add(CountryEntity country);
    public CountryEntity getById(Long id);
    public Set<CountryEntity> findAll();
    public CountryEntity delete(Long id);
}
