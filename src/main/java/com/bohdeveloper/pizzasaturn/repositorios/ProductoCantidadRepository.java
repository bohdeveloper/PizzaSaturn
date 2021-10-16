package com.bohdeveloper.pizzasaturn.repositorios;

import com.bohdeveloper.pizzasaturn.entidades.sucursales.Inventario;

import org.springframework.data.repository.CrudRepository;

public interface ProductoCantidadRepository extends CrudRepository<Inventario, Long> {
    Inventario findByNombre(String nombre);
}