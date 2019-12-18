package com.br.bionexoteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.bionexoteste.model.Geocode;

@Repository
public interface GeocodeRepository extends JpaRepository<Geocode, Integer> {

}
