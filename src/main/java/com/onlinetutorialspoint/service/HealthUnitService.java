package com.onlinetutorialspoint.service;

import org.springframework.data.domain.Page;
import com.onlinetutorialspoint.model.HealthUnit;

public interface HealthUnitService {
//	
	public Page<HealthUnit> search(Float lat, Float log, int page, int size); 
	
	public void save(HealthUnit healthUnit);
}