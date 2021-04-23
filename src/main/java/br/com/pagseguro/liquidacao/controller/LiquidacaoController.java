package br.com.pagseguro.liquidacao.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pagseguro.liquidacao.domain.Liquidacao;
import br.com.pagseguro.liquidacao.service.LiquidacaoService;

@RestController
@RequestMapping("/liquidacao")
public class LiquidacaoController {

	private final LiquidacaoService liquidacaoService;

	public LiquidacaoController(final LiquidacaoService liquidacaoService) {
		this.liquidacaoService = liquidacaoService;
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<PaymentDetailsResponse> details(@PathVariable("id") Long liquidacaoId) {
		final Optional<Liquidacao> by = liquidacaoService.findBy(liquidacaoId);

		if (by.isPresent()) {
			return ResponseEntity.ok(new PaymentDetailsResponse(by.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<LiquidacaoResponse> create(@RequestBody CriarLiquidacaoRequest criarLiquidacaoRequest)
			throws URISyntaxException {

		Liquidacao liquidacao = null;

		if (criarLiquidacaoRequest.getModalidadePagamento().equals("CREDITO")) {
			liquidacao = liquidacaoService.liquidarPagamentoCredito(criarLiquidacaoRequest.getClienteId(),
					criarLiquidacaoRequest.getValor());
		} else if (criarLiquidacaoRequest.getModalidadePagamento().equals("DEBITO")) {
			liquidacao = liquidacaoService.liquidarPagamentoDebito(criarLiquidacaoRequest.getClienteId(),
					criarLiquidacaoRequest.getValor());
		} else {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.created(new URI("/payments/" + liquidacao.getId())).body(new LiquidacaoResponse(liquidacao));
	}

}
