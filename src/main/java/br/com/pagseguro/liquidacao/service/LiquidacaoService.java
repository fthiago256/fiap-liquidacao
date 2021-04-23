package br.com.pagseguro.liquidacao.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.pagseguro.liquidacao.domain.Liquidacao;
import br.com.pagseguro.liquidacao.domain.ModalidadePagamento;
import br.com.pagseguro.liquidacao.repository.LiquidacaoRepository;

@Service
public class LiquidacaoService {

    private final LiquidacaoRepository liquidacaoRepository;

    @Autowired
    public LiquidacaoService(final LiquidacaoRepository liquidacaoRepository) {
        this.liquidacaoRepository = liquidacaoRepository;
    }

    public Liquidacao liquidarPagamentoCredito(final long clienteId, final BigDecimal valor) {
        return liquidarPagamento(clienteId, valor, ModalidadePagamento.CREDITO);
    }

    public Liquidacao liquidarPagamentoDebito(final long clienteId, final BigDecimal valor) {
        return liquidarPagamento(clienteId, valor, ModalidadePagamento.DEBITO);
    }
    
    private Liquidacao liquidarPagamento(final long clienteId, final BigDecimal valor, final ModalidadePagamento modalidadePagamento) {
    	LocalDateTime disponivelEm = LocalDateTime.now();
    	if(ModalidadePagamento.CREDITO.equals(modalidadePagamento)) {
    		disponivelEm = LocalDateTime.now().plusDays(27);	
    	}
        return liquidacaoRepository.save(new Liquidacao(clienteId, valor, disponivelEm, modalidadePagamento, LocalDateTime.now()));
    }

    public Page<Liquidacao> listarTodos() {
        return liquidacaoRepository.findAll(PageRequest.of(0, 10));
    }

    public Optional<Liquidacao> findBy(final Long liquidacaoId) {
        return liquidacaoRepository.findById(liquidacaoId);
    }
}
