package com.br.bionexoteste.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.br.bionexoteste.DTO.HealthUnitDTO;
import com.br.bionexoteste.service.GeocodeService;
import com.br.bionexoteste.service.ScoreService;

import java.util.List;

@Component
public class JobListener extends JobExecutionListenerSupport {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public JobListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            List<HealthUnitDTO> results = jdbcTemplate.query("SELECT ID ,ADDRESS ,CITY ,NAME ,PHONE ,GEOCODE_ID ,SCORE_ID  FROM HEALTH_UNIT ",
                    (rs,rowNum)->{
                        return new HealthUnitDTO(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), Integer.parseInt(rs.getString(7)), Integer.parseInt(rs.getString(6)));
                    }
            );
        }
    }
}
