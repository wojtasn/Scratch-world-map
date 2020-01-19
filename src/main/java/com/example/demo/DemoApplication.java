package com.example.demo;

import com.example.demo.common.domain.CountryTO;
import com.example.demo.common.domain.JourneyTO;
import com.example.demo.common.domain.UserTO;
import com.example.demo.persistence.entity.JourneyEntity;
import com.example.demo.service.CountryService;
import com.example.demo.service.JourneyService;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello world");
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CountryService countryService, UserService userService, JourneyService journeyService) {
		return args -> {
			Stream.of("Polska", "Argentyna", "Stany Zjednoczone", "Nowa Zelandia", "Meksyk", "Rosja").forEach(name -> {
				countryService.add(CountryTO.builder().name(name).build());
			});
			Stream.of("Adam", "Max").forEach(name -> {
				userService.add(UserTO.builder().email(name).build());
			});
			userService.addJourneyToUser(1L, JourneyTO.builder().country(1L).name("Moja pierwsza podroz").build());
			userService.addJourneyToUser(1L, JourneyTO.builder().country(2L).name("Moja druga podroz").build());
			userService.addJourneyToUser(2L, JourneyTO.builder().country(3L).name("Moja pierwsza podroz").build());
			System.out.println("Countries:");
			countryService.findAll().forEach(country -> System.out.println(country.getId()+": "+country.getName()));
			System.out.println("Users:");
			userService.findAll().forEach(user -> System.out.println(user.getId()+": "+user.getEmail()));
			System.out.println("Journeys");
			journeyService.findAll().forEach(journey -> System.out.println(journey.getId()+": "+journey.getCountry()+", name: "+journey.getName()));
			System.out.println("Adama:");
			userService.getUserCountries(1L).forEach(journey -> System.out.println(journey.getName()));
		};
	}
}
