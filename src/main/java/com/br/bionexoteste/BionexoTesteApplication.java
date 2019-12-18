package com.br.bionexoteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackageClasses = BionexoTesteApplication.class)
@EnableSwagger2
public class BionexoTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BionexoTesteApplication.class, args);
	}

}
