package com.example.demo.service;


import com.example.demo.common.domain.CountryTO;
import com.example.demo.common.domain.JourneyTO;
import com.example.demo.common.domain.UserTO;

import java.util.List;

public interface UserService {
    UserTO add(UserTO user);
    UserTO addJourneyToUser(Long userId, JourneyTO journeyTO);
    List<CountryTO> getUserCountries(Long userId);
    List<UserTO> findAll();
}
