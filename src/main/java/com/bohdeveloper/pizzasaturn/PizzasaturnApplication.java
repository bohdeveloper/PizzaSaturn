package com.bohdeveloper.pizzasaturn;

import java.math.BigDecimal;

import com.bohdeveloper.pizzasaturn.entidades.Producto;
import com.bohdeveloper.pizzasaturn.entidades.ProductoCategoria;
import com.bohdeveloper.pizzasaturn.entidades.Rol;
import com.bohdeveloper.pizzasaturn.entidades.Usuario;
import com.bohdeveloper.pizzasaturn.repositorios.ProductoCategoriaRepository;
import com.bohdeveloper.pizzasaturn.repositorios.ProductoRepository;
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
	private UsuarioRepository usRep;
	@Autowired
	private RolRepository roRep;

	/*
	 * @Autowired private ClienteRepository cRep;
	 */

	@Autowired
	private ProductoRepository prRep;

	@Autowired
	private ProductoCategoriaRepository prcaRep;

	@Override
	public void run(String... args) throws Exception {

		// Creación de roles de usuario
		roRep.save(new Rol(null, "ADMIN", null));
		roRep.save(new Rol(null, "USER", null));
		roRep.save(new Rol(null, "USERPRO", null));

		// Creación de usuarios
		Rol rolAdmin = roRep.findByNombre("ADMIN");
		Usuario admin = new Usuario(null, "admin", "admin@pizzasaturn.com",
				"$2a$12$Jlz419IFeL3JNzraQIxdBe.1gaAOHUyw3PrV/eyd97lruJrvzaC.2", rolAdmin);

		Rol rolUser = roRep.findByNombre("USER");
		Usuario user = new Usuario(null, "user", "user@pizzasaturn.com",
				"$2a$12$Jlz419IFeL3JNzraQIxdBe.1gaAOHUyw3PrV/eyd97lruJrvzaC.2", rolUser);

		Rol rolUserPro = roRep.findByNombre("USERPRO");
		Usuario userpro = new Usuario(null, "userpro", "userpro@pizzasaturn.com",
				"$2a$12$Jlz419IFeL3JNzraQIxdBe.1gaAOHUyw3PrV/eyd97lruJrvzaC.2", rolUserPro);

		usRep.save(admin);
		usRep.save(user);
		usRep.save(userpro);

		// Creación de categorias para ProductoRepository
		prcaRep.save(new ProductoCategoria(null, "Pizzas", null));
		prcaRep.save(new ProductoCategoria(null, "Ensaladas", null));
		prcaRep.save(new ProductoCategoria(null, "Complementos", null));
		prcaRep.save(new ProductoCategoria(null, "Bebidas", null));
		prcaRep.save(new ProductoCategoria(null, "Postres", null));

		// Creación de productos
		ProductoCategoria catPiz = prcaRep.findByNombre("Pizzas");
		Producto margarita = new Producto(null, "Margarita", new BigDecimal(09.90), 1, null, catPiz);
		Producto carbonara = new Producto(null, "Carbonara", new BigDecimal(12.90), 1, null, catPiz);
		Producto romana = new Producto(null, "Romana", new BigDecimal(10.90), 1, null, catPiz);
		Producto barbacoa = new Producto(null, "Barbacoa", new BigDecimal(12.90), 1, null, catPiz);
		Producto cuaQuesos = new Producto(null, "Cuatro quesos", new BigDecimal(12.90), 1, null, catPiz);
		Producto marinera = new Producto(null, "Marinera", new BigDecimal(10.90), 1, null, catPiz);
		Producto hawaiana = new Producto(null, "Hawaiana", new BigDecimal(11.90), 1, null, catPiz);

		prRep.save(margarita);
		prRep.save(carbonara);
		prRep.save(romana);
		prRep.save(barbacoa);
		prRep.save(cuaQuesos);
		prRep.save(marinera);
		prRep.save(hawaiana);
		

		ProductoCategoria catEns = prcaRep.findByNombre("Ensaladas");
	

		ProductoCategoria catCom = prcaRep.findByNombre("Complementos");

	
		ProductoCategoria catBeb = prcaRep.findByNombre("Bebidas");


		ProductoCategoria catPos = prcaRep.findByNombre("Postres");


	}

}
