package com.example.demo.service;

import com.example.demo.common.domain.JourneyTO;


import java.util.List;

public interface JourneyService {
    JourneyTO add(JourneyTO journey);
    JourneyTO getById(Long id);
    List<JourneyTO> findAll();
    JourneyTO delete(Long id);
}
