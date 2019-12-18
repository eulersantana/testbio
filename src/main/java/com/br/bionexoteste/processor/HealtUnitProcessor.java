package com.br.bionexoteste.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.br.bionexoteste.DTO.HealthUnitDTO;
import com.br.bionexoteste.model.CsvParse;
import com.br.bionexoteste.model.Geocode;
import com.br.bionexoteste.model.Score;
import com.br.bionexoteste.service.GeocodeService;
import com.br.bionexoteste.service.ScoreService;

public class HealtUnitProcessor implements ItemProcessor<CsvParse, HealthUnitDTO> {
	@Autowired
	private GeocodeService geocodeService;
	
	@Autowired
	private ScoreService scoreService;
	
	
    @Override
    public HealthUnitDTO process(final CsvParse csvParse) throws Exception {
    	Geocode geocode = new Geocode(Float.parseFloat(csvParse.getVlr_latitude()), Float.parseFloat(csvParse.getVlr_longitude()));
    	geocodeService.save(geocode);
    	
    	Score score = new Score(csvParse.getDsc_estrut_fisic_ambiencia(),csvParse.getDsc_adap_defic_fisic_idosos(),
    			csvParse.getDsc_equipamentos(), csvParse.getDsc_medicamentos());
    	scoreService.save(score);
  	
        final HealthUnitDTO healthUnitDTO = new HealthUnitDTO(Integer.parseInt(csvParse.getCod_cnes()), csvParse.getNom_estab(),
        		csvParse.getDsc_endereco(),
        		csvParse.getDsc_cidade(), 
        		csvParse.getDsc_telefone(),
        		score.getId(), geocode.getId());

        return healthUnitDTO;
    }

}
