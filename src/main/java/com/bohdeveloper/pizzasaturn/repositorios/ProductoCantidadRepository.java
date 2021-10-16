package com.bohdeveloper.pizzasaturn.repositorios;

import com.bohdeveloper.pizzasaturn.entidades.Inventario;

import org.springframework.data.repository.CrudRepository;

public interface ProductoCantidadRepository extends CrudRepository<Inventario, Long> {
    Inventario findByNombre(String nombre);
}