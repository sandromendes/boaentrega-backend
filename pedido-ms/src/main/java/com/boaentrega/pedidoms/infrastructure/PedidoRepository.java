package com.boaentrega.pedidoms.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boaentrega.pedidoms.domain.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, Long>{
	
	Pedido findPedidoByNumero(String numero);
	Pedido findPedidoByClienteId(Long clienteId);
}
