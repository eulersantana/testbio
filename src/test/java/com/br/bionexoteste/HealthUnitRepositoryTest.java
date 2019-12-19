package com.br.bionexoteste;

import java.util.Optional;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.bionexoteste.impl.HealthUnitServiceImpl;
import com.br.bionexoteste.model.Geocode;
import com.br.bionexoteste.model.HealthUnit;
import com.br.bionexoteste.model.Score;
import com.br.bionexoteste.repository.HealthUnitRepository;
import com.br.bionexoteste.service.HealthUnitService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HealthUnitRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private HealthUnitRepository healthUnitRepository;
    
    @Test
    public void whenFindByName_thenReturnHealthUnit() {
    	HealthUnit unidadeTeste = new HealthUnit();
    	unidadeTeste.setId(123);
 	    unidadeTeste.setName("unidade1");
 	    unidadeTeste.setAddress("Endereço Unidade 1");
 	    unidadeTeste.setPhone("(11)9999999999");
 	    unidadeTeste.setCity("Cidade");
 	    unidadeTeste.setGeocode(new Geocode(-12.0003F,0.99993F));
 	    unidadeTeste.setScore(new Score(1,1,1,1));
 	 
        healthUnitRepository.save(unidadeTeste);
     
        HealthUnit found = healthUnitRepository.findById(unidadeTeste.getId()).get();
        
        assertEquals(found.getName(), unidadeTeste.getName());
    }

}
