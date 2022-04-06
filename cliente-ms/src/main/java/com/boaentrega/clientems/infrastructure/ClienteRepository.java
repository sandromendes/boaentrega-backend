package com.boaentrega.clientems.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boaentrega.clientems.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
