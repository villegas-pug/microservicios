package com.microservicios.etapa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EntityScan({ "com.commons.utils.models.entities" })
@SpringBootApplication
public class EtapaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtapaApplication.class, args);
	}

}
