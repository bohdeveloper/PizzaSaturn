package com.bohdeveloper.pizzasaturn.repositorios;

import com.bohdeveloper.pizzasaturn.entidades.Rol;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RolRepository extends CrudRepository<Rol, Long> {
	Rol findByNombre(String nombre);

	@Query("SELECT r FROM Rol r JOIN FETCH r.usuarios WHERE r.nombre = ?1")
	Rol findByNombreConUsuarios(String nombre);

}
