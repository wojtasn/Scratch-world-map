package com.example.demo.common.mapper;

import com.example.demo.common.domain.JourneyTO;
import com.example.demo.persistence.entity.JourneyEntity;
import com.example.demo.persistence.repository.CountryRepository;
import com.example.demo.persistence.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JourneyMapper {

    private JourneyRepository journeyRepository;
    private CountryRepository countryRepository;

    @Autowired
    JourneyMapper(JourneyRepository journeyRepository, CountryRepository countryRepository){
        this.journeyRepository = journeyRepository;
        this.countryRepository = countryRepository;

    }

    public JourneyTO map(JourneyEntity journeyEntity){
        if (journeyEntity == null) {
            return null;
        }
        JourneyTO journey = new JourneyTO();
        journey.setId(journeyEntity.getId());
        journey.setCountry(journeyEntity.getCountry().getId());
        journey.setName(journeyEntity.getName());
        journey.setStartDate(journeyEntity.getStartDate());
        journey.setEndDate(journeyEntity.getEndDate());
        return journey;
    }

    public JourneyEntity map(JourneyTO journeyTO){
        if (journeyTO == null) {
            return null;
        }
        JourneyEntity journey = journeyRepository.getById(journeyTO.getId());
        if(journey == null){
            journey = new JourneyEntity();
        }
        journey.setCountry(countryRepository.getById(journeyTO.getCountry()));
        journey.setName(journeyTO.getName());
        journey.setStartDate(journeyTO.getStartDate());
        journey.setEndDate(journeyTO.getEndDate());
        return journey;
    }
}
