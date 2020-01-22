package com.example.demo.controller;

import com.example.demo.common.domain.CountryTO;
import com.example.demo.common.domain.JourneyTO;
import com.example.demo.common.domain.UserTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserTO> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public List<CountryTO> getUserCountries(@PathVariable Long userId) {
        return userService.getUserCountries(userId);
    }

    @PutMapping("/users/{userId}")
    public JourneyTO addJourneyToUser(@PathVariable Long userId, @RequestBody JourneyTO journey) {
        return userService.addJourneyToUser(userId, journey);
    }
}
