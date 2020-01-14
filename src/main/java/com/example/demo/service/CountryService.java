package com.example.demo.service;

import com.example.demo.common.domain.CountryTO;

import java.util.Set;

public interface CountryService {

    public CountryTO add(CountryTO country);
    public CountryTO getById(Long id);
    public Set<CountryTO> findAll();
    public CountryTO delete(Long id);

}
