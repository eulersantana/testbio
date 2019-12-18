package com.onlinetutorialspoint.controller;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.onlinetutorialspoint.model.HealthUnit;
import com.onlinetutorialspoint.service.HealthUnitService;

@RestController
@RequestMapping("/api/v1/find_ubs")
public class HealthUnitController {
	
	private static Logger log = LoggerFactory.getLogger(HealthUnitController.class);

	@Autowired
    HealthUnitService service;

    @GetMapping("")
    public ResponseEntity<HealthUnitResponse> search(
            @RequestParam("query") String query,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam( value = "size", required = false, defaultValue = "10") int size) {
    	
    	log.info("Get Page of the Health Unit ");
		
    	HealthUnitResponse response = new HealthUnitResponse();
    	
    	String pontos[] = query.split(",");
    	try {
				Page<HealthUnit> result = service.search(Float.parseFloat(pontos[0]), Float.parseFloat(pontos[1]), page, size);
		        
		    	response.setCurrentPage(result.getNumber());
		    	response.setPerPage(result.getNumberOfElements());
		    	response.setTotalEntries(result.getTotalElements());
		    	response.setEntries(result.getContent());
    		
		} catch (BeansException e) {
			log.error("There was a Business Exception. Exception: {}", e.getMessage(), e);
		}
       
        return ResponseEntity.ok(response);
    }

}
