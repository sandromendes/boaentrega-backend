package com.boaentrega.pedidoms.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "anticorruption-layer", path = "/anticorruption")
public interface AnticorruptionFeignClient {

	@GetMapping(value = "/rota/custo")
	ResponseEntity<Double> calcularCustoRota(@RequestParam String cepOrigem, @RequestParam String cepDestino);
}
