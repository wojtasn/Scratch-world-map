package com.example.demo.service.impl;

import com.example.demo.common.domain.CountryTO;
import com.example.demo.common.mapper.CountryMapper;
import com.example.demo.persistence.entity.CountryEntity;
import com.example.demo.persistence.repository.CountryRepository;
import com.example.demo.persistence.repository.impl.CountryRepositoryImpl;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;
    private CountryMapper countryMapper;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper){
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public CountryTO add(CountryTO country) {
        CountryEntity countryEntity = countryMapper.map(country);
        if(country.getId() == null){
            countryEntity.setId(countryRepository.updateLastId());
        }
        return countryMapper.map(countryRepository.add(countryEntity));
    }

    @Override
    public CountryTO getById(Long id) {
        return countryMapper.map(countryRepository.getById(id));
    }

    @Override
    public List<CountryTO> findAll() {
        return countryRepository.findAll().stream().map(c -> countryMapper.map(c)).collect(Collectors.toList());
    }

    @Override
    public CountryTO delete(Long id) {
        return countryMapper.map(countryRepository.delete(id));
    }
}
