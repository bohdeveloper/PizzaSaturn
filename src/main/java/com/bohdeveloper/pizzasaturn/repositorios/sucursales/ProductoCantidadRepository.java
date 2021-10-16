package com.bohdeveloper.pizzasaturn.repositorios.sucursales;

import com.bohdeveloper.pizzasaturn.entidades.sucursales.Inventario;

import org.springframework.data.repository.CrudRepository;

public interface ProductoCantidadRepository extends CrudRepository<Inventario, Long> {

}