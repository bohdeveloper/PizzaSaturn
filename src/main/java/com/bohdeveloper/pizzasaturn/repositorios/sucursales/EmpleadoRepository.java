package com.bohdeveloper.pizzasaturn.repositorios.sucursales;

import com.bohdeveloper.pizzasaturn.entidades.sucursales.Empleado;

import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    Empleado findByNombre(String nombre);
}