package com.apiconsumidora.apiconsumidora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiconsumidora.apiconsumidora.model.FuncionarioComSal;
import com.apiconsumidora.apiconsumidora.service.FuncionarioSalService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioSalario {
    

	@Autowired
	private FuncionarioSalService funcionariosalservice;
	
	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioComSal> obterFuncinario(@PathVariable Long id) {
		//FuncionarioComSal fsal = new FuncionarioComSal();
		//fsal.setNome("bruno");

		//return ResponseEntity.ok(fsal);
		//FuncionarioComSal fsal = this.funcionariosalservice.obterPorCodigo(id);
		FuncionarioComSal funcionarioComSal = this.funcionariosalservice.obterPorCodigo(id);

		return ResponseEntity.ok(funcionarioComSal);



	}

	@GetMapping("/{id}/salario")
	public ResponseEntity<FuncionarioComSal> obterFuncinarioComSal(@PathVariable Long id) {
		//FuncionarioComSal fsal = new FuncionarioComSal();
		//fsal.setNome("bruno");

		//return ResponseEntity.ok(fsal);
		//FuncionarioComSal fsal = this.funcionariosalservice.obterPorCodigo(id);
		FuncionarioComSal funcionarioComSal = this.funcionariosalservice.obterPorCodigo(id);

		return ResponseEntity.ok(funcionarioComSal);



	}


	/*@GetMapping("/funcionario/{id}/salario")
	public ResponseEntity<FuncionarioComSal> obterFuncinarioComSal(@PathVariable Long id) {
		
		FuncionarioComSal funcionarioComSal = this.funcionariosalservice.obterPorCodigo(id);

		return ResponseEntity.ok(funcionarioComSal);
	}*/
/*
	@GetMapping("/produto/{codigo}/preco/async")
	public ResponseEntity<FuncionarioComSal> obterProdutoComPrecoParalelo(@PathVariable Long id) {
		
		FuncionarioComSal funcionarioComSal = this.funcionariosalservice.obterPorCodigoParalelo(id);

		return ResponseEntity.ok(funcionarioComSal);
	}

	@PostMapping("/funcionario")
	public ResponseEntity<FuncionarioComSal> criarProduto(@RequestBody FuncionarioComSal produto) {

		FuncionarioComSal funcionarioComSal = this.funcionariosalservice.criar(produto);

		return ResponseEntity.ok(funcionarioComSal);
	} */
}
