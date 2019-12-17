package com.onlinetutorialspoint.listener;

import com.onlinetutorialspoint.model.EmployeeDTO;
import com.onlinetutorialspoint.model.Geocode;
import com.onlinetutorialspoint.model.HealthUnitDTO;
import com.onlinetutorialspoint.model.Score;
import com.onlinetutorialspoint.service.GeocodeService;
import com.onlinetutorialspoint.service.ScoreService;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JobListener extends JobExecutionListenerSupport {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    private GeocodeService geocodeService;
    
    @Autowired
    private ScoreService scoreService;
    
    @Autowired
    public JobListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
           // System.out.println("In Completion Listener ..");
            List<HealthUnitDTO> results = jdbcTemplate.query("SELECT ID ,ADDRESS ,CITY ,NAME ,PHONE ,GEOCODE_ID ,SCORE_ID  FROM HEALTH_UNIT ",
                    (rs,rowNum)->{
                    	Optional<Geocode> geocode = geocodeService.get(Integer.parseInt(rs.getString(6)));
                    	Optional<Score> score = scoreService.get(Integer.parseInt(rs.getString(7)));
                        return new HealthUnitDTO(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), score.get().getId(), geocode.get().getId());
                    }
            );
            //results.forEach(System.out::println);
        }
    }
}
