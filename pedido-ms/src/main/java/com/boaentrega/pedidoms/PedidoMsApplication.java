package com.boaentrega.pedidoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "cliente-ms")
@EnableFeignClients
@SpringBootApplication
public class PedidoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoMsApplication.class, args);
	}

}
