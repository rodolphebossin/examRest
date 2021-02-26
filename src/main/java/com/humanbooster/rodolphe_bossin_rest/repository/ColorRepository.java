package com.humanbooster.rodolphe_bossin_rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.humanbooster.rodolphe_bossin_rest.model.Color;

@Repository
public interface ColorRepository extends CrudRepository<Color, Long>{
	
	@Override
	List<Color> findAll();

}
