package com.onlinetutorialspoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreDTO {
	private Integer id;
	private Integer size;
	private Integer adaptationForSeniors;
	private Integer medicalEquipment;
	private Integer medecine;
	
	public ScoreDTO(Integer size, Integer adaptationForSeniors, Integer medicalEquipment, Integer medecine) {
		super();
		this.size = size;
		this.adaptationForSeniors = adaptationForSeniors;
		this.medicalEquipment = medicalEquipment;
		this.medecine = medecine;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getAdaptationForSeniors() {
		return adaptationForSeniors;
	}
	public void setAdaptationForSeniors(Integer adaptationForSeniors) {
		this.adaptationForSeniors = adaptationForSeniors;
	}
	public Integer getMedicalEquipment() {
		return medicalEquipment;
	}
	public void setMedicalEquipment(Integer medicalEquipment) {
		this.medicalEquipment = medicalEquipment;
	}
	public Integer getMedecine() {
		return medecine;
	}
	public void setMedecine(Integer medecine) {
		this.medecine = medecine;
	}
	
	
}
