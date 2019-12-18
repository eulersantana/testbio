package com.br.bionexoteste.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.br.bionexoteste.DTO.HealthUnitDTO;
import com.br.bionexoteste.listener.JobListener;
import com.br.bionexoteste.model.CsvParse;
import com.br.bionexoteste.processor.HealtUnitProcessor;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Bean
    public FlatFileItemReader<CsvParse> reader() {
        FlatFileItemReader<CsvParse> reader = new FlatFileItemReader<CsvParse>();
        reader.setResource(new ClassPathResource("ubs.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<CsvParse>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] {"vlr_latitude", "vlr_longitude", "cod_munic","cod_cnes","nom_estab","dsc_endereco","dsc_bairro","dsc_cidade","dsc_telefone","dsc_estrut_fisic_ambiencia","dsc_adap_defic_fisic_idosos","dsc_equipamentos","dsc_medicamentos" });
            }});
            
            setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(CsvParse.class);
            }});
        }});
        return reader;
    }


    @Bean
    public HealtUnitProcessor processor() {
        return new HealtUnitProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<HealthUnitDTO> writer() {
        JdbcBatchItemWriter<HealthUnitDTO> writer = new JdbcBatchItemWriter<HealthUnitDTO>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO HEALTH_UNIT (id, name, address, city, phone, score_id, geocode_id) " +
                "VALUES (:id, :name, :address,:city, :phone, :score, :geocode)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Job importUserJob(JobListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<CsvParse, HealthUnitDTO> chunk(13)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

}
