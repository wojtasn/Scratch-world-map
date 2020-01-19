package com.example.demo.persistence.repository.impl;

import com.example.demo.persistence.entity.JourneyEntity;
import com.example.demo.persistence.repository.JourneyRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JourneyRepositoryImpl implements JourneyRepository {
    private Long lastId = 1L;
    private List<JourneyEntity> journeyDB = new ArrayList<>();

    @Override
    public JourneyEntity add(JourneyEntity journey) {
        journeyDB.add(journey);
        return journey;
    }

    @Override
    public JourneyEntity getById(Long id) {
        return journeyDB.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<JourneyEntity> findAll() {
        return journeyDB;
    }

    @Override
    public JourneyEntity delete(Long id) {
        JourneyEntity journey = getById(id);
        journeyDB.remove(journey);
        return journey;
    }

    @Override
    public Long updateLastId() {
        return lastId++;
    }
}
