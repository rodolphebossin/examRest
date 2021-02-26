package com.humanbooster.rodolphe_bossin_rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.humanbooster.rodolphe_bossin_rest.model.Color;
import com.humanbooster.rodolphe_bossin_rest.repository.ColorRepository;



@RestController
@RequestMapping(value = "/api/colors")
public class ColorController {

	@Autowired
	private ColorRepository colorRepo;

	@GetMapping(value = "")
	List<Color> getAll() {
		return colorRepo.findAll();
	}

	@GetMapping(value = "/{color}", produces = { "application/json" })
	Color getOne(@PathVariable(name = "color", required = false) Color color) {
		if (color == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couleur introuvable");
		} else {
			return color;
		}
	}

	@PostMapping(value = "", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Color> saveColor(@Valid @RequestBody Color color) {
		this.colorRepo.save(color);
		return new ResponseEntity<Color>(color, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{color}", produces = { "application/json" })
	public ResponseEntity<Color> updateColor(@PathVariable(name = "color", required = false) Color color,
			@Valid @RequestBody Color modifiedColor) {
		if (color == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couleur introuvable");
		}
		modifiedColor.setId(color.getId());
		this.colorRepo.save(modifiedColor);
		return new ResponseEntity<Color>(modifiedColor, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{color}", produces = { "application/json" })
	public void deleteOne(@PathVariable(name="color", required = false) Color color) {
		if (color == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couleur introuvable");
		} else {
			this.colorRepo.delete(color);
		}
	}
}
