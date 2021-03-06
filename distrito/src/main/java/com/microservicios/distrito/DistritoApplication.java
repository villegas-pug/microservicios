package com.microservicios.distrito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.commons.utils.models.entities" })
public class DistritoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistritoApplication.class, args);
	}

}
