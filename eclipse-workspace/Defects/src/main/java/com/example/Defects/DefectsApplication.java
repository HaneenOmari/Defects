package com.example.Defects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;

import com.example.Defects.domain.App;
import com.example.Defects.domain.DefectRepository;
@SpringBootApplication
public class DefectsApplication {
	@Autowired
	private DefectRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DefectsApplication.class, args);
	}
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Save demo data to database
			repository.save(new App("1", "a", "aa"));
			repository.save(new App("2", "a", "aaa"));
			repository.save(new App("3", "b", "ss"));
		};
	}
}

