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
public class Geocode implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Float lat;
	
	private Float log;
    
	public Geocode() {
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLog() {
		return log;
	}

	public void setLog(Float log) {
		this.log = log;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Geocode(Float lat, Float log) {
		super();
		this.lat = lat;
		this.log = log;
	}

	public Geocode(Integer id, Float lat, Float log) {
		super();
		this.id = id;
		this.lat = lat;
		this.log = log;
	}
	
	
	
	
}
