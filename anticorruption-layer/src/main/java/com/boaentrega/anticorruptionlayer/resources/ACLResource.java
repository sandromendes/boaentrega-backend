package com.boaentrega.anticorruptionlayer.resources;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

		double factor = Math.PI;
		
		BigDecimal bdFactor = new BigDecimal(Double.toString(factor));
		bdFactor = bdFactor.setScale(2, RoundingMode.HALF_UP);
		
		double mockValue = diff / (bdFactor.doubleValue()*100);

		BigDecimal value = new BigDecimal(Double.toString(mockValue));
		value = value.setScale(2, RoundingMode.HALF_UP);
		
		return ResponseEntity.ok(value.doubleValue());
	}
}
