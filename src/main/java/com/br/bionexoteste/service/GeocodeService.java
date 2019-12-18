package com.br.bionexoteste.service;

import java.util.Optional;

import com.br.bionexoteste.model.Geocode;

public interface GeocodeService {
	public void save(Geocode geocode);
	
	public Optional<Geocode> get(int id);
}
