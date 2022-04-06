package com.boaentrega.clientems.service;

import java.util.List;

import com.boaentrega.clientems.domain.Cliente;

public interface ClienteService {
    List<Cliente> findAll();

    Cliente findById(Long id);

    Cliente save(Cliente cliente);
    
    Cliente update(Cliente cliente);

    void delete(Long id);
}
