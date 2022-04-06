package com.boaentrega.clientems.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boaentrega.clientems.domain.Cliente;
import com.boaentrega.clientems.dto.ClienteDTO;
import com.boaentrega.clientems.service.ClienteService;
import com.boaentrega.clientems.utils.Mapper;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> FindAll(){
		List<Cliente> list = clienteService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> FindById(@PathVariable Long id){
		Cliente cliente =  clienteService.findById(id);
		return ResponseEntity.ok(cliente);
	}
	
    @PostMapping
    public ResponseEntity<String> save(@RequestBody ClienteDTO clienteDTO) {
    	clienteService.save(Mapper.map(clienteDTO, Cliente.class));
        return ResponseEntity.ok("Cliente adicionado com sucesso");
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ClienteDTO clienteDTO) {
    	clienteService.update(Mapper.map(clienteDTO, Cliente.class));
        return ResponseEntity.ok("Cliente atualizado com sucesso");
    }

    @DeleteMapping(value = "/{numero}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
    	clienteService.delete(clienteService.findById(id).getId());
        return ResponseEntity.ok("Cliente removido com sucesso");
    }
}
