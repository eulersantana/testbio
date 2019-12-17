package com.onlinetutorialspoint.listener;

import com.onlinetutorialspoint.model.EmployeeDTO;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
           // System.out.println("In Completion Listener ..");
            List<EmployeeDTO> results = jdbcTemplate.query("SELECT id, first_name,last_name,company_name,address,city,county,state,zip FROM employee",
                    (rs,rowNum)->{
                        return new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),
                                rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                    }
            );
            //results.forEach(System.out::println);
        }
    }
}
