package com.apiconsumidora.apiconsumidora.model;

import java.lang.reflect.Constructor;

import org.yaml.snakeyaml.constructor.Construct;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuncionarioComSal {
    

    private Long id;
    private String nome;
    private float salario;


    
}
