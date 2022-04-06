package com.boaentrega.pedidoms.service;
import java.util.List;

import com.boaentrega.pedidoms.domain.Pedido;

public interface PedidoService {
    List<Pedido> findAll();

    Pedido findPedidoByNumero(String numero);

    List<Pedido> findPedidoByClienteId(Long clienteId);

    Pedido savePedido(Pedido pedido);
    
    Pedido updatePedido(Pedido pedido);

    void deletePedidoById(Long id);
    
    Double getValorNegociado(String numero, Long clienteId);
}
