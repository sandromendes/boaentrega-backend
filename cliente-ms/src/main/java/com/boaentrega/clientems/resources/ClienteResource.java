package com.boaentrega.clientems.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
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

@RefreshScope
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	private static Logger logger = LoggerFactory.getLogger(ClienteResource.class);
	
	@Value("${test.config}") private String testConfig;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/config")
	public ResponseEntity<String> getConfig(){
		return ResponseEntity.ok("CONFIG = " + testConfig);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> list = clienteService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
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
