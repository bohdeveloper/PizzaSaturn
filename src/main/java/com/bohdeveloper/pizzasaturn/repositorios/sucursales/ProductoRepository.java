package com.bohdeveloper.pizzasaturn.repositorios.sucursales;

import com.bohdeveloper.pizzasaturn.entidades.sucursales.Producto;

import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
    Producto findByNombre(String nombre);
}
