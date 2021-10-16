package com.bohdeveloper.pizzasaturn.repositorios.sucursales;

import com.bohdeveloper.pizzasaturn.entidades.sucursales.ProductoCategoria;

import org.springframework.data.repository.CrudRepository;

public interface ProductoCategoriaRepository extends CrudRepository<ProductoCategoria, Long> {
    ProductoCategoria findByNombre(String nombre);
}
