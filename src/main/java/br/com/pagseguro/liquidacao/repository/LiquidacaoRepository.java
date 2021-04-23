package br.com.pagseguro.liquidacao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.pagseguro.liquidacao.domain.Liquidacao;

@Repository
public interface LiquidacaoRepository extends PagingAndSortingRepository<Liquidacao, Long> {
}
