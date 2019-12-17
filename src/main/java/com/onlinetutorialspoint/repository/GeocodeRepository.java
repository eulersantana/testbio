package com.onlinetutorialspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinetutorialspoint.model.Geocode;

@Repository
public interface GeocodeRepository extends JpaRepository<Geocode, Integer> {

}
