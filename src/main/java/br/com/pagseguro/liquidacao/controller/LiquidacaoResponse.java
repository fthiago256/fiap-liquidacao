package br.com.pagseguro.liquidacao.controller;

import java.time.LocalDateTime;

import br.com.pagseguro.liquidacao.domain.Liquidacao;

public class LiquidacaoResponse {

	private final long id;
	private final LocalDateTime createdAt;

	public LiquidacaoResponse(final Liquidacao payment) {
		id = payment.getId();
		createdAt = payment.getCreatedAt();
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public long getId() {
		return id;
	}
}
