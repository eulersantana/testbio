package com.br.bionexoteste.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.bionexoteste.model.Geocode;
import com.br.bionexoteste.repository.GeocodeRepository;
import com.br.bionexoteste.service.GeocodeService;

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
