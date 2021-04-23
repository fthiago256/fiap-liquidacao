package br.com.pagseguro.liquidacao.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


@Entity
public class Liquidacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long clienteId;
    
    private BigDecimal valor;
    
    private LocalDateTime disponivelEm;
    
    @Enumerated(EnumType.STRING)
    private ModalidadePagamento modalidadePagamento;

    private LocalDateTime createdAt;

    public Liquidacao() {
    }

    public Liquidacao(final long clienteId, final BigDecimal valor, final LocalDateTime disponivelEm, final ModalidadePagamento modalidadePagamento, final LocalDateTime createdAt) {
        this.clienteId = clienteId;
        this.valor = valor;
        this.disponivelEm = disponivelEm;
        this.modalidadePagamento = modalidadePagamento;
        this.createdAt = createdAt;
    }
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (clienteId ^ (clienteId >>> 32));
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((disponivelEm == null) ? 0 : disponivelEm.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((modalidadePagamento == null) ? 0 : modalidadePagamento.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Liquidacao other = (Liquidacao) obj;
		if (clienteId != other.clienteId)
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (disponivelEm == null) {
			if (other.disponivelEm != null)
				return false;
		} else if (!disponivelEm.equals(other.disponivelEm))
			return false;
		if (id != other.id)
			return false;
		if (modalidadePagamento != other.modalidadePagamento)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getDisponivelEm() {
		return disponivelEm;
	}

	public void setDisponivelEm(LocalDateTime disponivelEm) {
		this.disponivelEm = disponivelEm;
	}

	public ModalidadePagamento getModalidadePagamento() {
		return modalidadePagamento;
	}

	public void setModalidadePagamento(ModalidadePagamento modalidadePagamento) {
		this.modalidadePagamento = modalidadePagamento;
	}

	public long getId() {
		return id;
	}

	public long getClienteId() {
		return clienteId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	

 
}
