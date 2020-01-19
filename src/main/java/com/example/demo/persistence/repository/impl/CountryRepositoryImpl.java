package com.example.demo.persistence.repository.impl;

import com.example.demo.persistence.entity.CountryEntity;
import com.example.demo.persistence.repository.CountryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    private Long lastId = 1L;
    private List<CountryEntity> countryDB = new ArrayList<>();

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
    public List<CountryEntity> findAll() {
        return countryDB;
    }

    @Override
    public CountryEntity delete(Long id){
        CountryEntity country = getById(id);
        countryDB.remove(country);
        return country;
    }

    @Override
    public Long updateLastId() {
        return lastId++;
    }
}
