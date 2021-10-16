package com.bohdeveloper.pizzasaturn.repositorios;

import com.bohdeveloper.pizzasaturn.entidades.sucursales.ProductoCategoria;

import org.springframework.data.repository.CrudRepository;

public interface ProductoCategoriaRepository extends CrudRepository<ProductoCategoria, Long> {
    ProductoCategoria findByNombre(String nombre);
}
