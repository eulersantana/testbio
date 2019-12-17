package com.onlinetutorialspoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.model.Employee;
import com.onlinetutorialspoint.repository.HealthUnitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class HealthUnitServiceImpl implements HealthUnitService {

	@Autowired
	private HealthUnitRepository healthUnitRepository;



    public Page<Employee> search(
            String searchTerm,
            int page,
            int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "lastName");

        return healthUnitRepository.search(
                searchTerm.toLowerCase(),
                pageRequest);
    }

    public Page<Employee> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "name");
        return new PageImpl<>(
        		healthUnitRepository.findAll(), 
                pageRequest, size);
    }


}