package com.example.demo.service;

import com.example.demo.common.domain.CountryTO;

import java.util.List;

public interface CountryService {
    CountryTO add(CountryTO country);
    CountryTO getById(Long id);
    List<CountryTO> findAll();
    CountryTO delete(Long id);
}
