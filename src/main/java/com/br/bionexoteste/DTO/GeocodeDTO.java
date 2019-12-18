package com.br.bionexoteste.DTO;

import javax.persistence.Column;

public class GeocodeDTO {
	private Float lat;
	private Float log;
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
	public GeocodeDTO(Float lat, Float log) {
		super();
		this.lat = lat;
		this.log = log;
	}
	
	
	
	
}
