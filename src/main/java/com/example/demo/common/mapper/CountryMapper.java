package com.example.demo.common.mapper;

import com.example.demo.common.domain.CountryTO;
import com.example.demo.persistence.entity.CountryEntity;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryTO mapCountryTO(CountryEntity countryEntity) {
        if (countryEntity == null) {
            return null;
        }
        return CountryTO.builder().id(countryEntity.getId()).name(countryEntity.getName()).build();
    }

    public CountryEntity mapToCountryEntity(CountryTO countryTO) {
        if (countryTO == null) {
            return null;
        }
        return CountryEntity.builder().name(countryTO.getName()).build();
    }
}
