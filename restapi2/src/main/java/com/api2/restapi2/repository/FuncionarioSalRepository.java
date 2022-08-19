package com.api2.restapi2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api2.restapi2.model.FuncionarioSal;

@Repository
public interface FuncionarioSalRepository extends JpaRepository<FuncionarioSal, Long>{
    
}

