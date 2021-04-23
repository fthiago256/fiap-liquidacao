package br.com.pagseguro.liquidacao.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.pagseguro.liquidacao.domain.Liquidacao;
import br.com.pagseguro.liquidacao.domain.ModalidadePagamento;

public class PaymentDetailsResponse {

    private final long id;
    private final LocalDateTime disponivelEm;
    private final ModalidadePagamento modalidadePagamento;
    private final BigDecimal valor;
    private final LocalDateTime createdAt;

    PaymentDetailsResponse(final Liquidacao liquidacao) {
        id = liquidacao.getId();
        disponivelEm = liquidacao.getDisponivelEm();
        modalidadePagamento = liquidacao.getModalidadePagamento();
        valor = liquidacao.getValor();
        createdAt = liquidacao.getCreatedAt();
    }

    public long getId() {
        return id;
    }

	public LocalDateTime getDisponivelEm() {
		return disponivelEm;
	}

	public ModalidadePagamento getModalidadePagamento() {
		return modalidadePagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

  
}
