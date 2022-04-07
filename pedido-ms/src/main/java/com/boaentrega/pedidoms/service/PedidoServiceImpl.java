package com.boaentrega.pedidoms.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boaentrega.pedidoms.domain.Cliente;
import com.boaentrega.pedidoms.domain.Pedido;
import com.boaentrega.pedidoms.feignclients.ClienteFeignClient;
import com.boaentrega.pedidoms.infrastructure.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteFeignClient clienteFeignClient;
    
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findPedidoById(Long id) {
    	return pedidoRepository.findById(id).orElse(null);
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

	@Override
	public Double getValorNegociado(Long pedidoId, Long clienteId) {

		Cliente cliente = clienteFeignClient.FindById(clienteId).getBody();
    	
    	if(cliente == null)
    		return BigDecimal.ZERO.doubleValue();
    	
    	Pedido pedido = pedidoRepository.findById(pedidoId).orElse(null);
    	
    	if(pedido == null)
    		return BigDecimal.ZERO.doubleValue();
    	
    	Double valor = pedido.getTotal() - pedido.getTotal()*cliente.getDescontoContratual()/100;
    	
    	return valor;
	}

}
