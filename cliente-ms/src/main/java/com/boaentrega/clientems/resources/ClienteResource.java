package com.boaentrega.clientems.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boaentrega.clientems.domain.Cliente;
import com.boaentrega.clientems.infrastructure.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteRepository repository;

	@GetMapping
	public ResponseEntity<List<Cliente>> FindAll(){
		List<Cliente> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> FindById(@PathVariable Long id){
		Cliente cliente =  repository.findById(id).get();
		return ResponseEntity.ok(cliente);
	}
}
