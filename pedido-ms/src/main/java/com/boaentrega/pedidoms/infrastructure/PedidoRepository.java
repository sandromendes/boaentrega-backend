package com.boaentrega.pedidoms.infrastructure;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.boaentrega.pedidoms.domain.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, Long>{
	
	@Query("{ 'numero' : ?0 }")
	Pedido findPedidoByNumero(String numero);
	List<Pedido> findPedidoByClienteId(Long clienteId);
}
