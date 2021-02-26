package com.humanbooster.rodolphe_bossin_rest.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Color {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Basic
	@NotBlank(message = "Veuillez entrer un libellé")
	@Column(name = "libelle", nullable = false, length = 250)
	private String libelle;
	
	@Basic
	@Pattern(regexp = "^rgb[(](?:\\s*0*(?:\\d\\d?(?:\\.\\d+)?(?:\\s*%)?|\\.\\d+\\s*%|100(?:\\.0*)?\\s*%|(?:1\\d\\d|2[0-4]\\d|25[0-5])(?:\\.\\d+)?)\\s*(?:,(?![)])|(?=[)]))){3}[)]$", message = "Veuillez entrer un code rgb au format rgb(r,g,b) !")
	@NotBlank(message = "Veuillez entrer un code rgb")
	@Column(name = "code_rgb", nullable = false, length = 250)
	private String codeRgb;

	public Color() {
	}

	public Color(@NotBlank(message = "Veuillez entrer un libellé") String libelle,
			@Pattern(regexp = "rgb\\(\\s*(?:(?:\\d{1,2}|1\\d\\d|2(?:[0-4]\\d|5[0-5]))\\s*,?){3}\\)$", message = "Code invalide") @NotBlank(message = "Veuillez entrer un code rgb") String codeRgb) {
		super();
		this.libelle = libelle;
		this.codeRgb = codeRgb;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCodeRgb() {
		return codeRgb;
	}

	public void setCodeRgb(String codeRgb) {
		this.codeRgb = codeRgb;
	}
	
	

}
