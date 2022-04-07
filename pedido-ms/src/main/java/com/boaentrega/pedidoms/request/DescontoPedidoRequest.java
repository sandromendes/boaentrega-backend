package com.boaentrega.pedidoms.request;

public class DescontoPedidoRequest {
	
	public Long clienteId;
	public Long pedidoId;
	
	public DescontoPedidoRequest() {
	}

	public DescontoPedidoRequest(Long clienteId, Long numeroPedido) {
		super();
		this.clienteId = clienteId;
		this.pedidoId = numeroPedido;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getNumeroPedido() {
		return pedidoId;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.pedidoId = numeroPedido;
	}
}
