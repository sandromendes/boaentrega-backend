package com.boaentrega.clientems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boaentrega.clientems.domain.Cliente;
import com.boaentrega.clientems.infrastructure.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
    private ClienteRepository clienteRepository;

	@Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente save(Cliente pedido) {
        return clienteRepository.save(pedido);
    }
    
    @Override
    public Cliente update(Cliente pedido) {
        return clienteRepository.save(pedido);
    }

    @Override
    public void delete(Long id) {
    	clienteRepository.deleteById(id);
    }
}
