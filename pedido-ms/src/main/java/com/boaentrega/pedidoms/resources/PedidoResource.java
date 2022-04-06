package com.boaentrega.pedidoms.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.boaentrega.pedidoms.dto.PedidoDTO;
import com.boaentrega.pedidoms.service.PedidoService;
import com.boaentrega.pedidoms.utils.Mapper;

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

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody PedidoDTO pedidoDTO) {
    	pedidoService.savePedido(Mapper.map(pedidoDTO, Pedido.class));
        return new ResponseEntity("Pedido adicionado com sucesso", HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody PedidoDTO pedidoDTO) {
    	pedidoService.updatePedido(Mapper.map(pedidoDTO, Pedido.class));
        return new ResponseEntity("Pedido atualizado com sucesso", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{numero}")
    public ResponseEntity<?> deleteByNumber(@PathVariable String numero) {
    	pedidoService.deletePedidoById(pedidoService.findPedidoByNumero(numero).getId());
        return new ResponseEntity("Pedido removido com sucesso", HttpStatus.OK);
    }
}
