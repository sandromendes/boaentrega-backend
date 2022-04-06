package com.boaentrega.pedidoms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boaentrega.pedidoms.domain.Pedido;
import com.boaentrega.pedidoms.infrastructure.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findPedidoByNumero(String numero) {
        return pedidoRepository.findPedidoByNumero(numero);
    }

    @Override
    public List<Pedido> findPedidoByClienteId(Long clienteId) {
        return pedidoRepository.findPedidoByClienteId(clienteId);
    }

    @Override
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    
    @Override
    public Pedido updatePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deletePedidoById(Long id) {
    	pedidoRepository.deleteById(id);
    }

}
