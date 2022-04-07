package com.boaentrega.pedidoms.dto;

public class NegociacaoDTO {

	public Double valorOriginal;
	public Double desconto;
	public Double valorNegociado;
	public String message;
	
	public NegociacaoDTO() {
	}

	public NegociacaoDTO(Double valorOriginal, Double desconto, Double valorNegociado, String message) {
		super();
		this.valorOriginal = valorOriginal;
		this.desconto = desconto;
		this.valorNegociado = valorNegociado;
		this.message = message;
	}

	public Double getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(Double valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorNegociado() {
		return valorNegociado;
	}

	public void setValorNegociado(Double valorNegociado) {
		this.valorNegociado = valorNegociado;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
