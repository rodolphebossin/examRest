package com.humanbooster.rodolphe_bossin_rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.humanbooster.rodolphe_bossin_rest.model.Car;
import com.humanbooster.rodolphe_bossin_rest.model.Color;
import com.humanbooster.rodolphe_bossin_rest.repository.CarRepository;
import com.humanbooster.rodolphe_bossin_rest.repository.ColorRepository;

@Configuration
public class FeedBddWithData {

	private static final Logger log = LoggerFactory.getLogger(FeedBddWithData.class);

	@Bean
	CommandLineRunner InitCarBdd(CarRepository carRepo) {
		if (carRepo.count() == 0) {

			Car car1 = new Car("Citroen", "C4", "diesel", 2018, 130000, 13000, "très bon état");
			Car car2 = new Car("Renault", "Mégane", "essence", 2018, 130000, 13000, "bon état");

			return args -> {
				log.info("Preloading" + carRepo.save(car1));
				log.info("Preloading" + carRepo.save(car2));
			};
		} else {
			return args -> {
				log.info("Cars already loaded");
			};
		}
	}
	
	
	@Bean
	CommandLineRunner InitColorBdd(ColorRepository colorRepo) {
		if (colorRepo.count() == 0) {

			Color color1 = new Color("Vert clair", "rgb(152,251,152)");
			Color color2 = new Color("White", "rgb(255,255,255)");

			return args -> {
				log.info("Preloading" + colorRepo.save(color1));
				log.info("Preloading" + colorRepo.save(color2));
			};
		} else {
			return args -> {
				log.info("Colors already loaded");
			};
		}
	}
	 

}
