package com.br.bionexoteste.model;

import static java.util.Optional.ofNullable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class HealthUnit implements Serializable {
	@Id
	private Integer id;

	@Column(length=200, nullable=true)
	private String name;
	
	@Column(length=200, nullable=true)
	private String address;
	
	@Column(length=200, nullable=true)
	private String city;
	
	@Column(length=200, nullable=true)
	private String phone;
	
	@OneToOne
	private Score score;
	
	@OneToOne
	private Geocode geocode;
	
	public HealthUnit() {
		
	}
	
	public HealthUnit(Integer id, String name, String address, String city, String phone, Score score,
			Geocode geocode) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.score = score;
		this.geocode = geocode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Geocode getGeocode() {
		return geocode;
	}

	public void setGeocode(Geocode geocode) {
		this.geocode = geocode;
	}

	@Override
	public String toString() {
		return "HealthUnit [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", phone="
				+ phone + ", score=" + score + ", geocode=" + geocode + "]";
	}
	
	

}
