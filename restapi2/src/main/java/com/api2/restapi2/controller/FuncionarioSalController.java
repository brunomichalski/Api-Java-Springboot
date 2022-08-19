package com.api2.restapi2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api2.restapi2.model.FuncionarioSal;
import com.api2.restapi2.repository.FuncionarioSalRepository;

@RestController
@RequestMapping("/funcionariosal")
public class FuncionarioSalController {
    @Autowired
    private FuncionarioSalRepository funcionariosalRepository;

    @GetMapping
    public List<FuncionarioSal> listar() {
        return funcionariosalRepository.findAll();      
    }

    @GetMapping("/{id}")
    public FuncionarioSal listaFuncionarioSal(@PathVariable Long id) {
        return funcionariosalRepository.findById(id).get();      
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioSal adicionar(@RequestBody FuncionarioSal funcionarioSal){
        return funcionariosalRepository.save(funcionarioSal);
    }

    @PutMapping
    public void alterar(@RequestBody FuncionarioSal funcionarioSal){
        if (funcionarioSal.getId()>0) {
            funcionariosalRepository.save(funcionarioSal);
        }
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        funcionariosalRepository.deleteById(id);
        System.out.println("Deletado com sucesso!");;
    }
}
