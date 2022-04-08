package com.boaentrega.clientems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class ClienteMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteMsApplication.class, args);
	}

}
