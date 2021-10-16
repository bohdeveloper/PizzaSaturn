package com.bohdeveloper.pizzasaturn.repositorios.usuarios;

import com.bohdeveloper.pizzasaturn.entidades.usuarios.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findByNombre(String nombre);
}
