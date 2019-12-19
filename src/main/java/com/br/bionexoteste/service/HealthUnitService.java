package com.br.bionexoteste.service;

import org.springframework.data.domain.Page;

import com.br.bionexoteste.model.HealthUnit;

public interface HealthUnitService {
//	
	public Page<HealthUnit> search(Float lat, Float log, int page, int size); 
	
	public void save(HealthUnit healthUnit);
	

	public HealthUnit getByName(String name);
}