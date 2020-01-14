package com.example.demo.persistence.repository.impl;

import com.example.demo.persistence.entity.CountryEntity;
import com.example.demo.persistence.entity.UserEntity;
import com.example.demo.persistence.repository.CountryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    public Set<CountryEntity> countryDB = new HashSet<>();

    @Override
    public CountryEntity add(CountryEntity country) {
        countryDB.add(country);
        return country;
    }

    @Override
    public CountryEntity getById(Long id){
        return countryDB.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Set<CountryEntity> findAll() {
        return countryDB;
    }

    @Override
    public CountryEntity delete(Long id){
        CountryEntity country = getById(id);
        countryDB.remove(country);
        return country;
    }
}
