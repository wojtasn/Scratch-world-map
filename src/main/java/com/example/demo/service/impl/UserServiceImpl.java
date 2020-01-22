package com.example.demo.service.impl;

import com.example.demo.common.domain.CountryTO;
import com.example.demo.common.domain.JourneyTO;
import com.example.demo.common.domain.UserTO;
import com.example.demo.common.mapper.CountryMapper;
import com.example.demo.common.mapper.JourneyMapper;
import com.example.demo.common.mapper.UserMapper;
import com.example.demo.persistence.entity.JourneyEntity;
import com.example.demo.persistence.entity.UserEntity;
import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.service.JourneyService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private JourneyService journeyService;
    private JourneyMapper journeyMapper;
    private CountryMapper countryMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, JourneyService journeyService, JourneyMapper journeyMapper, CountryMapper countryMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.journeyService = journeyService;
        this.journeyMapper = journeyMapper;
        this.countryMapper = countryMapper;
    }

    @Override
    public UserTO add(UserTO user) {
        UserEntity userEntity = userMapper.map(user);
        if(user.getId() == null){
            userEntity.setId(userRepository.updateLastId());
        }
        return userMapper.map(userRepository.add(userEntity));
    }

    @Override
    public JourneyTO addJourneyToUser(Long userId, JourneyTO journeyTO) {
        UserEntity user = userRepository.getById(userId);
        user.addJourney(journeyMapper.map(journeyService.add(journeyTO)));
        return journeyTO;
    }

    @Override
    public List<CountryTO> getUserCountries(Long userId) {
        List<JourneyEntity> userJourneys = userRepository.getById(userId).getJourneys();
        return userJourneys.stream().distinct().map(j -> countryMapper.map(j.getCountry())).collect(Collectors.toList());
    }

    @Override
    public List<UserTO> findAll() {
        return userRepository.findAll().stream().map(u -> userMapper.map(u)).collect(Collectors.toList());
    }

    @Override
    public UserTO getById(Long userId) {
        return userMapper.map(userRepository.getById(userId));
    }
}
