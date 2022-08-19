package com.apiconsumidora.apiconsumidora.service;

import com.apiconsumidora.apiconsumidora.model.FuncionarioComSal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FuncionarioSalService {

  @Autowired
  private WebClient webClientFuncionarios;

  @Autowired
  private WebClient webClientSalarios;

  public FuncionarioComSal obterPorCodigo(Long id) {
    Mono<FuncionarioComSal> monoFuncionario =
      this.webClientFuncionarios.method(HttpMethod.GET)
        .uri("/funcionarios/{id}", id)
        .retrieve()
        .bodyToMono(FuncionarioComSal.class);

    Mono<FuncionarioComSal> monoSalario =
      this.webClientSalarios.method(HttpMethod.GET)
        .uri("/funcionariosal/{id}", id)
        .retrieve()
        .bodyToMono(FuncionarioComSal.class);

    FuncionarioComSal funcionarioComSal = Mono
      .zip(monoFuncionario, monoSalario)
      .map(
        Tuple -> {
          Tuple.getT1().setSalario(Tuple.getT2().getSalario());
          return Tuple.getT1();
        }
      )
      .block();

    return funcionarioComSal;
  }
  /* 
	public ProdutoComPreco obterPorCodigoSincrono(Long codigoProduto) {

		Mono<ProdutoComPreco> monoProduto = this.webClientProdutos
			.method(HttpMethod.GET)
			.uri("/produtos/{codigo}", codigoProduto)
			.retrieve()
			.bodyToMono(ProdutoComPreco.class);
	
		Mono<ProdutoComPreco> monoPreco = this.webClientPrecos
				.method(HttpMethod.GET)
				.uri("/precos/{codigo}", codigoProduto)
				.retrieve()
				.bodyToMono(ProdutoComPreco.class);
		
		ProdutoComPreco produto = monoProduto.block();
		ProdutoComPreco preco = monoPreco.block();

		produto.setPreco(preco.getPreco());

		return produto;
	}
	
	public ProdutoComPreco criar(ProdutoComPreco produtoComPreco) {

		Mono<ProdutoComPreco> monoProduto = 
				this.webClientProdutos
					.post()
					.uri("/produtos")
					.body(BodyInserters.fromValue(produtoComPreco))
					.retrieve()
					.bodyToMono(ProdutoComPreco.class);

		return monoProduto.block();
	}*/
}
