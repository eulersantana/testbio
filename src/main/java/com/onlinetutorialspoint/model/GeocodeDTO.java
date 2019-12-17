package com.onlinetutorialspoint.model;

import javax.persistence.Column;

public class GeocodeDTO {
	private Integer id;
	private Double lat;
	private Double lng;
	
	
	public GeocodeDTO(Integer id, Double lat, Double lng) {
		super();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "GeocodeDTO [id=" + id + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
	
}
