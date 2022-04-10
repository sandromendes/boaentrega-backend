package com.boaentrega.userms.resources;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boaentrega.userms.UserDTO;
import com.boaentrega.userms.domain.User;
import com.boaentrega.userms.service.UserService;
import com.boaentrega.userms.utils.Mapper;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User cliente =  userService.findById(id);
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		User cliente =  userService.findByEmail(email);
		return ResponseEntity.ok(cliente);
	}
	
    @PostMapping
    public ResponseEntity<String> save(@RequestBody UserDTO userDTO) {
    	userService.save(Mapper.map(userDTO, User.class));
        return ResponseEntity.ok("Usuário adicionado com sucesso");
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
    	userService.update(Mapper.map(userDTO, User.class));
        return ResponseEntity.ok("Usuário atualizado com sucesso");
    }

    @DeleteMapping(value = "/{numero}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
    	userService.delete(userService.findById(id).getId());
        return ResponseEntity.ok("Usuário removido com sucesso");
    }
}
