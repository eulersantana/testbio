package com.onlinetutorialspoint.service;

import org.springframework.data.domain.Page;

import com.onlinetutorialspoint.model.Employee;

public interface HealthUnitService {

	public Page<Employee> findAll();
	
	public Page<Employee> search(String searchTerm, int page, int size); 
}