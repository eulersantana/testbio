package com.onlinetutorialspoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthUnitDTO {
	private int id;
	private String name;
	private String address;
	private String city;
	private String phone;
	private int score;
	private int geocode;
	
	
	
	public HealthUnitDTO(int id, String name, String address, String city, String phone, int score,
			int geocode) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.score = score;
		this.geocode = geocode;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getGeocode() {
		return geocode;
	}


	public void setGeocode(int geocode) {
		this.geocode = geocode;
	}


	@Override
	public String toString() {
		return "HealthUnitDTO [name=" + name + ", address=" + address + ", city=" + city + ", phone="
				+ phone + ", score=" + score + ", geocode=" + geocode + "]";
	}
	
	
}
