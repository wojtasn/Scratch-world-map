package com.example.demo;

import com.example.demo.common.domain.CountryTO;
import com.example.demo.service.CountryService;
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
	CommandLineRunner init(CountryService countryService) {
		return args -> {
			Stream.of("Polska", "Argentyna", "Stany Zjednoczone", "Nowa Zelandia", "Meksyk", "Rosja").forEach(name -> {
				CountryTO country = CountryTO.builder().name(name).build();
				countryService.add(country);
			});
			countryService.findAll().forEach(country -> System.out.println(country.getName()));
		};
	}

}
