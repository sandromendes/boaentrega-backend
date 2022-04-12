package com.boaentrega.pedidoms.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boaentrega.pedidoms.domain.Cliente;
import com.boaentrega.pedidoms.domain.Pedido;
import com.boaentrega.pedidoms.dto.NegociacaoDTO;
import com.boaentrega.pedidoms.feignclients.AnticorruptionFeignClient;
import com.boaentrega.pedidoms.feignclients.ClienteFeignClient;
import com.boaentrega.pedidoms.infrastructure.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteFeignClient clienteFeignClient;
    
    @Autowired
    private AnticorruptionFeignClient anticorruptionFeignClient;
    
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findPedidoById(Long id) {
    	return pedidoRepository.findById(id).orElse(new Pedido());
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
	public NegociacaoDTO getValorNegociado(Long pedidoId, Long clienteId) {

		Cliente cliente = clienteFeignClient.FindById(clienteId).getBody();
    	
		Double custo = anticorruptionFeignClient.calcularCustoRota("50911990", "53944958").getBody();
		
    	if(cliente == null)
    		return new NegociacaoDTO("", BigDecimal.ZERO.doubleValue(), 
    				BigDecimal.ZERO.doubleValue(), BigDecimal.ZERO.doubleValue(), BigDecimal.ZERO.doubleValue(), new String[] {"Cliente não encontrado"});
    	
    	Pedido pedido = pedidoRepository.findById(pedidoId).orElse(null);
    	
    	if(pedido == null)
    		return new NegociacaoDTO("", BigDecimal.ZERO.doubleValue(), 
    				BigDecimal.ZERO.doubleValue(), BigDecimal.ZERO.doubleValue(), BigDecimal.ZERO.doubleValue(), new String[] {"Pedido não encontrado"});
    	
    	Double valor = pedido.getTotal() - pedido.getTotal()*cliente.getDescontoContratual()/100;
    	
    	String[] mensagens = {"Acessou o cliente-ms com sucesso", "Acessou a camada anticorrupção com sucesso"};
    	
    	return new NegociacaoDTO(pedido.getNumero(), pedido.getTotal(), cliente.getDescontoContratual(), valor, custo, mensagens);
	}

}
