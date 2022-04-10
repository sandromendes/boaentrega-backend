package com.boaentrega.oauthms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OauthMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthMsApplication.class, args);
	}

}
