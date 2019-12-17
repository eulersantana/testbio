package com.onlinetutorialspoint.service;

import java.util.Optional;

import com.onlinetutorialspoint.model.Geocode;

public interface GeocodeService {
	public void save(Geocode geocode);
	
	public Optional<Geocode> get(int id);
}
