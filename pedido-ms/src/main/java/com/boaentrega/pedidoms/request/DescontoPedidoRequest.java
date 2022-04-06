package com.boaentrega.pedidoms.request;

public class DescontoPedidoRequest {
	
	public Long clienteId;
	public String numeroPedido;
	
	public DescontoPedidoRequest() {
	}

	public DescontoPedidoRequest(Long clienteId, String numeroPedido) {
		super();
		this.clienteId = clienteId;
		this.numeroPedido = numeroPedido;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
}
