package com.example.demo.common.mapper;

import com.example.demo.common.domain.UserTO;
import com.example.demo.persistence.entity.UserEntity;
import com.example.demo.persistence.repository.JourneyRepository;
import com.example.demo.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private JourneyRepository journeyRepository;
    private UserRepository userRepository;

    @Autowired
    public UserMapper(JourneyRepository journeyRepository, UserRepository userRepository){
        this.journeyRepository = journeyRepository;
        this.userRepository = userRepository;
    }

    public UserTO map(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        UserTO user = new UserTO();
        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setLevelId(userEntity.getLevelId());
        user.setPoints(userEntity.getPoints());
        if(userEntity.hasJourneys()) {
            user.setJourneys(userEntity.getJourneys().stream().map(j -> j.getId()).collect(Collectors.toList()));
        }
        return user;
    }

    public UserEntity map(UserTO userTO) {
        if (userTO == null) {
            return null;
        }
        UserEntity user = userRepository.getById(userTO.getId());
        if(user == null) {
            user = new UserEntity();
        }
        user.setEmail(userTO.getEmail());
        user.setPassword(userTO.getPassword());
        user.setLevelId(userTO.getLevelId());
        user.setPoints(userTO.getPoints());
        if(userTO.hasJourneys()) {
            user.setJourneys(userTO.getJourneys().stream().map(j -> journeyRepository.getById(j)).collect(Collectors.toList()));
        }
        return user;
    }
}
