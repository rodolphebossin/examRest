package com.humanbooster.rodolphe_bossin_rest.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Basic
	@NotBlank(message = "Veuillez entrer une marque")
	@Column(name = "marque", nullable = false, length = 250)
	private String marque;
	
	@Basic
	@NotBlank(message = "Veuillez entrer un modèle")
	@Column(name = "modele", nullable = false, length = 250)
	private String modele;
	
	@Basic
	@NotBlank(message = "Veuillez entrer un carburant")
	@Column(name = "carburant", nullable = false, length = 250)
	private String carburant;
	
	@Basic
	@NotNull(message = "Veuillez entrer une année")
	@Column(name = "annee", nullable = false)
	private Integer annee;
	
	@Basic
	@NotNull(message = "Veuillez entrer un prix")
	@Column(name = "kilometrage", nullable = false)
	private Integer kilometrage;
	
	@Basic
	@NotNull(message = "Veuillez entrer un prix")
	@Column(name = "prix", nullable = false)
	private Integer prix;
	
	@Basic
	@NotBlank(message = "Veuillez entrer une description")
	@Column(name = "description", nullable = false, length = 250)
	private String description;

	public Car() {
	}

	public Car(@NotBlank(message = "Veuillez entrer une marque") String marque,
			@NotBlank(message = "Veuillez entrer un modèle") String modele,
			@NotBlank(message = "Veuillez entrer un carburant") String carburant,
			@NotNull(message = "Veuillez entrer une année") Integer annee,
			@NotNull(message = "Veuillez entrer un prix") Integer kilometrage,
			@NotNull(message = "Veuillez entrer un prix") Integer prix,
			@NotBlank(message = "Veuillez entrer une description") String description) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.carburant = carburant;
		this.annee = annee;
		this.kilometrage = kilometrage;
		this.prix = prix;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCarburant() {
		return carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public Integer getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(Integer kilometrage) {
		this.kilometrage = kilometrage;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
