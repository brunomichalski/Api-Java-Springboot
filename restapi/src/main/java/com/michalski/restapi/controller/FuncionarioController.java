package com.michalski.restapi.controller;

import java.lang.reflect.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.michalski.restapi.model.Funcionario;
import com.michalski.restapi.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();      
    }

    @GetMapping("/{id}")
    public Funcionario listaFuncionario(@PathVariable Long id) {
        return funcionarioRepository.findById(id).get();      
    }

   /*  @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<Cliente> listar() {

        Cliente c = new Cliente();
        c.setId(1L);
        c.setNome("Bruno");
        c.setEmail("bruno@email.com.br");
        Cliente c1 = new Cliente();
        c1.setId(1L);
        c1.setNome("Gabriela");
        c1.setEmail("gabriela@email.com.br");
        Cliente c2= new Cliente();
        c2.setId(1L);
        c2.setNome("lucas");
        c2.setEmail("lucas@email.com.br");
        Cliente c3 = new Cliente();
        c3.setId(1L);
        c3.setNome("frank");
        c3.setEmail("frank@email.com.br");
       
        return ResponseEntity.status(HttpStatus.OK).body(c);      
    }*/


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario adicionar(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping
    public void alterar(@RequestBody Funcionario funcionario){
        if (funcionario.getId()>0) {
            funcionarioRepository.save(funcionario);
        }
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        funcionarioRepository.deleteById(id);
        System.out.println("Deletado com sucesso!");;
    }
}
