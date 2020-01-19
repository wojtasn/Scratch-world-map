package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.CountryEntity;
import com.example.demo.persistence.entity.JourneyEntity;


import java.util.List;

public interface JourneyRepository {
    JourneyEntity add(JourneyEntity journey);
    JourneyEntity getById(Long id);
    List<JourneyEntity> findAll();
    JourneyEntity delete(Long id);
    Long updateLastId();
}