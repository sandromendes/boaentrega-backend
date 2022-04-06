package com.boaentrega.pedidoms.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.boaentrega.pedidoms.domain.Cliente;

@Component
@FeignClient(name = "cliente-ms", url = "localhost:8001", path = "/clientes")
public interface ClienteFeignClient {

	@GetMapping(value = "/{id}")
	ResponseEntity<Cliente> FindById(@PathVariable Long id);
}
