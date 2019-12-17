package com.onlinetutorialspoint.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.onlinetutorialspoint.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface HealthUnitRepository extends JpaRepository<Employee, Integer>  {
	
	 @Query("FROM Employee c " +
	           "WHERE LOWER(c.firstName) like %:searchTerm% " +
	           "OR LOWER(c.lastName) like %:searchTerm%")
	 Page<Employee> search(@Param("searchTerm") String searchTerm, Pageable pageable);
	    

}

