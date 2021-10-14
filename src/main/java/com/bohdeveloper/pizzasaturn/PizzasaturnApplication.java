package com.bohdeveloper.pizzasaturn;

import com.bohdeveloper.pizzasaturn.entidades.Rol;
import com.bohdeveloper.pizzasaturn.entidades.Usuario;
import com.bohdeveloper.pizzasaturn.repositorios.RolRepository;
import com.bohdeveloper.pizzasaturn.repositorios.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzasaturnApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PizzasaturnApplication.class, args);
	}

	@Autowired
	private UsuarioRepository uRep;
	@Autowired
	private RolRepository rRep;

	@Override
	public void run(String... args) throws Exception {

		// Creación de roles de usuario
		rRep.save(new Rol(null, "ADMIN", null));
		rRep.save(new Rol(null, "USER", null));
		rRep.save(new Rol(null, "USERPRO", null));

		Rol rolAdmin = rRep.findByNombre("ADMIN");
		Rol rolUser = rRep.findByNombre("USER");
		Rol rolUserPro = rRep.findByNombre("USERPRO");

		// Creación de usuarios
		uRep.save(new Usuario(null, "admin", "admin@pizzasaturn.com",
				"$2a$12$Jlz419IFeL3JNzraQIxdBe.1gaAOHUyw3PrV/eyd97lruJrvzaC.2", rolAdmin));

		uRep.save(new Usuario(null, "user", "user@pizzasaturn.com",
				"$2a$12$Jlz419IFeL3JNzraQIxdBe.1gaAOHUyw3PrV/eyd97lruJrvzaC.2", rolUser));

		uRep.save(new Usuario(null, "userpro", "userpro@pizzasaturn.com",
				"$2a$12$Jlz419IFeL3JNzraQIxdBe.1gaAOHUyw3PrV/eyd97lruJrvzaC.2", rolUserPro));

	}

}
