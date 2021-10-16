package com.bohdeveloper.pizzasaturn.repositorios.usuarios;

import com.bohdeveloper.pizzasaturn.entidades.usuarios.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
