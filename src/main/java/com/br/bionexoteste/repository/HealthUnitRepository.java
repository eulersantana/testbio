package com.br.bionexoteste.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.bionexoteste.model.HealthUnit;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface HealthUnitRepository extends PagingAndSortingRepository<HealthUnit, Integer>  {
	
	static final String HAVERSINE_PART = "(6371 * acos(cos(radians(:latitude)) * cos(radians(m.geocode.lat)) * cos(radians(m.geocode.log) - "
			+ "radians(:longitude)) + sin(radians(:latitude)) * sin(radians(m.geocode.lat))))";

	@Query("SELECT m FROM HealthUnit m WHERE "+HAVERSINE_PART+" < 10000 ORDER BY "+HAVERSINE_PART+" DESC")
	public Page<HealthUnit> search(@Param("latitude") Float lat, @Param("longitude") Float log, Pageable pageable);
	 
	@Query("SELECT m FROM HealthUnit m WHERE m.name = :name")
	public HealthUnit findByName(@Param("name")String name);

}


