package com.example.demo.common.mapper;

import com.example.demo.common.domain.UserTO;
import com.example.demo.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserTO mapToUserTO(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        List<Long> countriesIds = userEntity.getCountries()
                .stream()
                .map(e -> e.getId())
                .collect(Collectors.toList());

        return UserTO.builder().id(userEntity.getId()).email(userEntity.getEmail()).password(userEntity.getPassword()).levelId(userEntity.getLevelId()).points(userEntity.getPoints()).build();
    }

    public UserEntity map(UserTO userTO) {
        UserEntity user = new UserEntity();
        return user;
    }
}
