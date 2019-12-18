package com.onlinetutorialspoint.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.onlinetutorialspoint.model.HealthUnit;
import com.onlinetutorialspoint.repository.HealthUnitRepository;
import com.onlinetutorialspoint.service.HealthUnitService;

import org.springframework.data.domain.PageRequest;

@Service
public class HealthUnitServiceImpl implements HealthUnitService {

	@Autowired
	private HealthUnitRepository healthUnitRepository;


    public Page<HealthUnit> search( Float lat, Float log, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return healthUnitRepository.search(lat, log, pageRequest);
    }

    public void save(HealthUnit healthUnit) {
    	healthUnitRepository.save(healthUnit);
    }


}