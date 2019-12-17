package com.onlinetutorialspoint.processor;

import com.onlinetutorialspoint.model.CsvParse;
import com.onlinetutorialspoint.model.Employee;

import com.onlinetutorialspoint.model.EmployeeDTO;
import com.onlinetutorialspoint.model.Geocode;
import com.onlinetutorialspoint.model.HealthUnit;
import com.onlinetutorialspoint.model.HealthUnitDTO;
import com.onlinetutorialspoint.model.Score;
import com.onlinetutorialspoint.service.GeocodeService;
import com.onlinetutorialspoint.service.HealthUnitService;
import com.onlinetutorialspoint.service.ScoreService;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class HealtUnitProcessor implements ItemProcessor<CsvParse, HealthUnitDTO> {
	@Autowired
	private GeocodeService geocodeService;
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private HealthUnitService healthUnitService;
	
    @Override
    public HealthUnitDTO process(final CsvParse csvParse) throws Exception {
//        System.out.println("Transforming Employee(s) to EmployeeDTO(s)..");
    	Geocode geocode = new Geocode(Float.parseFloat(csvParse.getVlr_latitude()), Float.parseFloat(csvParse.getVlr_longitude()));
    	geocodeService.save(geocode);
    	
    	Score score = new Score(csvParse.getDsc_estrut_fisic_ambiencia(),csvParse.getDsc_adap_defic_fisic_idosos(),
    			csvParse.getDsc_equipamentos(), csvParse.getDsc_medicamentos());
    	scoreService.save(score);
//    	healthUnitService.save(new HealthUnit(Integer.parseInt(csvParse.getCod_cnes()), csvParse.getNom_estab(),
//        		csvParse.getDsc_endereco(),
//        		csvParse.getDsc_cidade(), 
//        		csvParse.getDsc_telefone(),
//        		score, geocode));
//    	
        final HealthUnitDTO healthUnitDTO = new HealthUnitDTO(Integer.parseInt(csvParse.getCod_cnes()), csvParse.getNom_estab(),
        		csvParse.getDsc_endereco(),
        		csvParse.getDsc_cidade(), 
        		csvParse.getDsc_telefone(),
        		score.getId(), geocode.getId());

        return healthUnitDTO;
    }

}
