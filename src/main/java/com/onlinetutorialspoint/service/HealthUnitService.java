package com.onlinetutorialspoint.service;

import org.springframework.data.domain.Page;

import com.onlinetutorialspoint.model.Employee;
import com.onlinetutorialspoint.model.HealthUnit;

public interface HealthUnitService {
//
	public Page<HealthUnit> findAll();
//	
//	public Page<Employee> search(String searchTerm, int page, int size); 
	public void save(HealthUnit healthUnit);
}