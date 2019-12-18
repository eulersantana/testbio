package com.onlinetutorialspoint.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.model.Geocode;
import com.onlinetutorialspoint.repository.GeocodeRepository;
import com.onlinetutorialspoint.service.GeocodeService;

@Service
public class GeocodeServiceImpl implements GeocodeService{
	@Autowired
	private GeocodeRepository geocodeRepository;
	
	@Override
	public void save(Geocode geocode) {
		geocodeRepository.saveAndFlush(geocode);
	}

	@Override
	public Optional<Geocode> get(int id) {
		// TODO Auto-generated method stub
		return geocodeRepository.findById(id);
	}

}
