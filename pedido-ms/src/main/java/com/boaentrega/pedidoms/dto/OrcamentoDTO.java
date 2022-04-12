package com.boaentrega.pedidoms.dto;

import java.util.UUID;

public class OrcamentoDTO {
	
	public UUID codigo;
	public Double valor;
	public String[] message;
	
	public OrcamentoDTO() {
		this.codigo = UUID.randomUUID();
	}

	public OrcamentoDTO(Double valor, String[] message) {
		super();
		this.codigo = UUID.randomUUID();
		this.valor = valor;
		this.message = message;
	}

	public UUID getCodigo() {
		return codigo;
	}

	public void setCodigo(UUID codigo) {
		this.codigo = codigo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}
}
