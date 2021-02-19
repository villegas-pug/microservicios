package com.microservicios.operativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OperativoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperativoApplication.class, args);
	}

}
