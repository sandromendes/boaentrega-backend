package com.boaentrega.pedidoms.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.boaentrega.pedidoms.domain.Cliente;
import com.boaentrega.pedidoms.domain.Pedido;
import com.boaentrega.pedidoms.dto.PedidoDTO;
import com.boaentrega.pedidoms.request.DescontoPedidoRequest;
import com.boaentrega.pedidoms.service.PedidoService;
import com.boaentrega.pedidoms.utils.Mapper;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Value("${cliente-ms.host}")
	private String clientHost;
	
    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {
    	List<PedidoDTO> lista = Mapper.mapAll(pedidoService.findAll(), PedidoDTO.class);
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/byNumero/{numero}")
    public ResponseEntity<PedidoDTO> findByNumero(@PathVariable("numero") String numero) {
    	PedidoDTO pedido = Mapper.map(pedidoService.findPedidoByNumero(numero), PedidoDTO.class);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping(value = "/byClienteId/{clienteId}")
    public ResponseEntity<PedidoDTO> findByEmail(@PathVariable("clienteId") Long clienteId) {
    	PedidoDTO pedido = Mapper.map(pedidoService.findPedidoByClienteId(clienteId), PedidoDTO.class);
        return ResponseEntity.ok(pedido);
    }
    
    @GetMapping(value = "/valorNegociado")
    public ResponseEntity<Double> getValorNegociado(@RequestBody DescontoPedidoRequest request){
    	
    	Map<String, String> uriVariables = new HashMap<>();
    	uriVariables.put("id", request.clienteId.toString());
    	
    	Cliente cliente = restTemplate.getForObject(clientHost + "/clientes/{id}", Cliente.class, uriVariables);
    	
    	if(cliente == null)
    		return ResponseEntity.notFound().build();
    	
    	PedidoDTO pedido = Mapper.map(pedidoService.findPedidoByNumero(request.numeroPedido), PedidoDTO.class);
    	
    	if(pedido == null)
    		return ResponseEntity.notFound().build();
    	
    	Double valor = pedido.getTotal() - pedido.getTotal()*cliente.getDescontoContratual()/100;
    	
    	return ResponseEntity.ok(valor);
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
