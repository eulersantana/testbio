package com.onlinetutorialspoint.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.onlinetutorialspoint.model.Employee;
import com.onlinetutorialspoint.model.HealthUnit;
import com.onlinetutorialspoint.service.HealthUnitService;;

@RestController
@RequestMapping("/api/v1/find_ubs")
public class HealthUnitController {
	
	@Autowired
    HealthUnitService service;

//    @GetMapping("/search")
//    public Page<Employee> search(
//            @RequestParam("searchTerm") String searchTerm,
//            @RequestParam(
//                    value = "page",
//                    required = false,
//                    defaultValue = "0") int page,
//            @RequestParam(
//                    value = "size",
//                    required = false,
//                    defaultValue = "10") int size) {
//        return service.search(searchTerm, page, size);
//
//    }

    @GetMapping
    public Page<HealthUnit> getAll() {
        return service.findAll();
    }

}
