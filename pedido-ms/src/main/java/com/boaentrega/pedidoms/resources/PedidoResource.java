package com.boaentrega.pedidoms.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boaentrega.pedidoms.domain.Pedido;
import com.boaentrega.pedidoms.dto.NegociacaoDTO;
import com.boaentrega.pedidoms.dto.PedidoDTO;
import com.boaentrega.pedidoms.request.DescontoPedidoRequest;
import com.boaentrega.pedidoms.service.PedidoService;
import com.boaentrega.pedidoms.utils.Mapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {
    	List<PedidoDTO> lista = Mapper.mapAll(pedidoService.findAll(), PedidoDTO.class);
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> findByNumero(@PathVariable("id") Long id) {
    	PedidoDTO pedido = Mapper.map(pedidoService.findPedidoById(id), PedidoDTO.class);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping(value = "/byClienteId/{clienteId}")
    public ResponseEntity<PedidoDTO> findByEmail(@PathVariable("clienteId") Long clienteId) {
    	PedidoDTO pedido = Mapper.map(pedidoService.findPedidoByClienteId(clienteId), PedidoDTO.class);
        return ResponseEntity.ok(pedido);
    }
    
    @HystrixCommand(fallbackMethod = "getValorNegociadoAlternative")
    @GetMapping(value = "/valorNegociado")
    public ResponseEntity<NegociacaoDTO> getValorNegociado(@RequestBody DescontoPedidoRequest request){
    	
    	NegociacaoDTO negociacao = pedidoService.getValorNegociado(request.pedidoId, request.clienteId);
    	
    	return ResponseEntity.ok(negociacao);
    }
    
    public ResponseEntity<NegociacaoDTO> getValorNegociadoAlternative(DescontoPedidoRequest request){
    	
    	PedidoDTO pedido = Mapper.map(pedidoService.findPedidoById(request.pedidoId), PedidoDTO.class);
    	
    	Double descontoPadrao = 0.5;
    	
    	Double valor = pedido.getTotal() - pedido.getTotal()*descontoPadrao/100;
    	
    	NegociacaoDTO negociacao = new NegociacaoDTO(pedido.getTotal(), descontoPadrao, valor, "Chamada fallback... Foi aplicado o desconto padrão");
    	
    	return ResponseEntity.ok(negociacao);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody PedidoDTO pedidoDTO) {
    	pedidoService.savePedido(Mapper.map(pedidoDTO, Pedido.class));
        return ResponseEntity.ok("Pedido adicionado com sucesso");
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody PedidoDTO pedidoDTO) {
    	pedidoService.updatePedido(Mapper.map(pedidoDTO, Pedido.class));
        return ResponseEntity.ok("Pedido atualizado com sucesso");
    }

    @DeleteMapping(value = "/{numero}")
    public ResponseEntity<?> deleteByNumber(@PathVariable String numero) {
    	pedidoService.deletePedidoById(pedidoService.findPedidoByNumero(numero).getId());
        return ResponseEntity.ok("Pedido removido com sucesso");
    }
}
