package com.bohdeveloper.pizzasaturn.repositorios;

import com.bohdeveloper.pizzasaturn.entidades.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}