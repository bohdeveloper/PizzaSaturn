package com.bohdeveloper.pizzasaturn.repositorios;

import com.bohdeveloper.pizzasaturn.entidades.Producto;

import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
    
}
