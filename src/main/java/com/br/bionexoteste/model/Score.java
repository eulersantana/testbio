package com.br.bionexoteste.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Score implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer size;
	
	private Integer adaptationForSeniors;
	
	private Integer medicalEquipment;
	
	private Integer medecine;

	public Integer getSize() {
		return size;
	}
	
	public Score() {
		
	}
	
	public Score(Integer size, Integer adaptationForSeniors, Integer medicalEquipment, Integer medecine) {
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
	
	public static Integer preProcessingScore(String sizeStr) {
		
		if (sizeStr.toUpperCase().indexOf("DESEMPENHO MUITO ACIMA") >= 0) {
			return 3;
		} else {
			if (sizeStr.toUpperCase().indexOf("DESEMPENHO ACIMA") >= 0) {
				return 2;
			}
		}
		return 1;
	}


	@Override
	public String toString() {
		return "Score [id=" + id + ", size=" + size + ", adaptationForSeniors=" + adaptationForSeniors
				+ ", medicalEquipment=" + medicalEquipment + ", medecine=" + medecine + "]";
	}


	
}
