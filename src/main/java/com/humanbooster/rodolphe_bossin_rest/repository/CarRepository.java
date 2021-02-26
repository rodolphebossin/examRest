package com.humanbooster.rodolphe_bossin_rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.humanbooster.rodolphe_bossin_rest.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>{
	
	@Override List<Car> findAll();


}
