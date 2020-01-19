package com.example.demo.common.mapper;

import com.example.demo.common.domain.CountryTO;
import com.example.demo.persistence.entity.CountryEntity;
import com.example.demo.persistence.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    private CountryRepository countryRepository;

    @Autowired
    public CountryMapper(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public CountryTO map(CountryEntity countryEntity) {
        if (countryEntity == null) {
            return null;
        }
        CountryTO country = new CountryTO();
        country.setId(countryEntity.getId());
        country.setName(countryEntity.getName());
        return country;
    }

    public CountryEntity map(CountryTO countryTO) {
        if (countryTO == null) {
            return null;
        }
        CountryEntity country = countryRepository.getById(countryTO.getId());
        if(country == null){
            country = new CountryEntity();
        }
        country.setName(countryTO.getName());
        return country;
    }
}
