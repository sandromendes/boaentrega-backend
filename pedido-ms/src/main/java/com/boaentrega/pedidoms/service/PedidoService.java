package com.boaentrega.pedidoms.service;
import java.util.List;

import com.boaentrega.pedidoms.domain.Pedido;
import com.boaentrega.pedidoms.dto.NegociacaoDTO;

public interface PedidoService {
    List<Pedido> findAll();

    Pedido findPedidoById(Long id);
    
    Pedido findPedidoByNumero(String numero);

    List<Pedido> findPedidoByClienteId(Long clienteId);

    Pedido savePedido(Pedido pedido);
    
    Pedido updatePedido(Pedido pedido);

    void deletePedidoById(Long id);
    
    NegociacaoDTO getValorNegociado(Long pedidoId, Long clienteId);
}
