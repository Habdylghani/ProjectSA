package com.sa.firstprojectsa;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class FirstProjectSaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectSaApplication.class, args);
	}

}
