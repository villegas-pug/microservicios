package com.microservicios.tipotramite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EntityScan({ "com.commons.utils.models.entities" })
@SpringBootApplication
public class TipotramiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TipotramiteApplication.class, args);
	}

}
