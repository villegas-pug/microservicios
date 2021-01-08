package com.microservicios.interpol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EntityScan({ "com.commons.utils.models.entities" })
public class InterpolApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterpolApplication.class, args);
	}

}
