package com.onlinetutorialspoint.model;


import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee implements Serializable {
	@Id
    private String id;
	
	@Column(length=200, nullable=true)
    private String firstName;
	
	@Column(length=200, nullable=true)
    private String lastName;
	 
	@Column(length=200, nullable=true)
    private String companyName;
	 
	@Column(length=200, nullable=true)
    private String address;
	
	@Column(length=200, nullable=true)
    private String city;
	
	@Column(length=200, nullable=true)
    private String county;
	
	@Column(length=200, nullable=true)
    private String state;
	
	@Column(length=200, nullable=true)
    private String zip;


	public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String companyName, String address, String city, String county, String state, String zip) {
    	this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.county = county;
        this.state = state;
        this.zip = zip;
    }
    
    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
