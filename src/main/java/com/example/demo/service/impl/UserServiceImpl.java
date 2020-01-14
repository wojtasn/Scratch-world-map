package com.example.demo.service.impl;

import com.example.demo.common.domain.UserTO;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Override
    public Long countVisitedCountries(UserTO user) {
        return user.getCountries().stream().count();
    }
}
