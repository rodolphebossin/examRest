package com.humanbooster.rodolphe_bossin_rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.humanbooster.rodolphe_bossin_rest.model.Car;
import com.humanbooster.rodolphe_bossin_rest.repository.CarRepository;

@RestController
@RequestMapping(value="/api/cars")
public class CarController {
	
	@Autowired
	private CarRepository carRepo;
	
	@GetMapping(value="")
	List<Car> getAll(){
		return carRepo.findAll();
	}
	
	@PostMapping(value="", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Car> saveCar(@Valid @RequestBody Car car){
		this.carRepo.save(car);
		return new ResponseEntity<Car>(car, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/{car}", produces = { "application/json" })
	Car getOne(@PathVariable(name = "car", required = false)Car car) {
		if(car == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Voiture introuvable");
		} else {
			return car;
		}
	}

}
