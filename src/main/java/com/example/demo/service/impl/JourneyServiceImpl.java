package com.example.demo.service.impl;

import com.example.demo.common.domain.JourneyTO;
import com.example.demo.common.mapper.JourneyMapper;
import com.example.demo.persistence.entity.JourneyEntity;
import com.example.demo.persistence.repository.JourneyRepository;
import com.example.demo.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class JourneyServiceImpl implements JourneyService {

    private JourneyRepository journeyRepository;
    private JourneyMapper journeyMapper;

    @Autowired
    JourneyServiceImpl(JourneyRepository journeyRepository, JourneyMapper journeyMapper){
        this.journeyRepository = journeyRepository;
        this.journeyMapper = journeyMapper;
    }

    @Override
    public JourneyTO add(JourneyTO journey) {
        JourneyEntity journeyEntity = journeyMapper.map(journey);
        if(journey.getId() == null) {
            journeyEntity.setId(journeyRepository.updateLastId());
        }
        return journeyMapper.map(journeyRepository.add(journeyEntity));
    }

    @Override
    public JourneyTO getById(Long id) {
        return journeyMapper.map(journeyRepository.getById(id));
    }

    @Override
    public List<JourneyTO> findAll() {
        return journeyRepository.findAll().stream().map(j -> journeyMapper.map(j)).collect(Collectors.toList());
    }

    @Override
    public JourneyTO delete(Long id) {
        return journeyMapper.map(journeyRepository.delete(id));
    }
}
