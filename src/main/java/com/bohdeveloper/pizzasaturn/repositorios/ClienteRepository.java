package com.bohdeveloper.pizzasaturn.repositorios;

import com.bohdeveloper.pizzasaturn.entidades.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}
