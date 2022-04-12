package com.boaentrega.anticorruptionlayer.resources;

import java.util.Random;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/anticorruption")
public class ACLResource {

	@GetMapping(value = "/rota/custo")
	public ResponseEntity<Double> calcularCustoRota(@RequestParam String cepOrigem, @RequestParam String cepDestino){
		
		//Mock
		int diff = Math.abs(Integer.parseInt(cepDestino) - Integer.parseInt(cepOrigem));
		
		Random random = new Random();
		double randomValue = 100 + (diff) * random.nextDouble();

		return ResponseEntity.ok(randomValue);
	}
}
