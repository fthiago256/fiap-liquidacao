package br.com.pagseguro.liquidacao.controller;

import java.math.BigDecimal;

public class CriarLiquidacaoRequest {
	private String modalidadePagamento;
	private long clienteId;
	private BigDecimal valor;

	public String getModalidadePagamento() {
		return modalidadePagamento;
	}

	public void setModalidadePagamento(String modalidadePagamento) {
		this.modalidadePagamento = modalidadePagamento;
	}

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
