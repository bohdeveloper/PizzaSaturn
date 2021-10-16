package com.bohdeveloper.pizzasaturn;

import java.math.BigDecimal;

import com.bohdeveloper.pizzasaturn.entidades.Inventario;
import com.bohdeveloper.pizzasaturn.entidades.Producto;
import com.bohdeveloper.pizzasaturn.entidades.ProductoCategoria;
import com.bohdeveloper.pizzasaturn.entidades.Rol;
import com.bohdeveloper.pizzasaturn.entidades.Usuario;
import com.bohdeveloper.pizzasaturn.repositorios.ProductoCantidadRepository;
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

	@Autowired
	private ProductoRepository prRep;

	@Autowired
	private ProductoCategoriaRepository prcatRep;

	@Autowired 
	private ProductoCantidadRepository prcanRep;

	/*
	 * @Autowired private ClienteRepository cRep;
	 */


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

		// Creación de categorias para productos
		prcatRep.save(new ProductoCategoria(null, "Pizzas", null));
		prcatRep.save(new ProductoCategoria(null, "Ensaladas", null));
		prcatRep.save(new ProductoCategoria(null, "Complementos", null));
		prcatRep.save(new ProductoCategoria(null, "Bebidas", null));
		prcatRep.save(new ProductoCategoria(null, "Postres", null));

		// Creación de productos y sus cantidades en stock
		ProductoCategoria catPiz = prcatRep.findByNombre("Pizzas");
		Producto pizSaturn = new Producto(null, "Saturn", new BigDecimal(12.90), 1, null, catPiz);
		Inventario cantPizSaturn = new Inventario(null, "Pizza Saturn", 10, pizSaturn);

		Producto margarita = new Producto(null, "Margarita", new BigDecimal(09.90), 1, null, catPiz);

		Producto carbonara = new Producto(null, "Carbonara", new BigDecimal(12.90), 1, null, catPiz);

		Producto romana = new Producto(null, "Romana", new BigDecimal(10.90), 1, null, catPiz);

		Producto barbacoa = new Producto(null, "Barbacoa", new BigDecimal(12.90), 1, null, catPiz);

		Producto cuaQueso = new Producto(null, "Cuatro quesos", new BigDecimal(12.90), 1, null, catPiz);

		Producto marinera = new Producto(null, "Marinera", new BigDecimal(10.90), 1, null, catPiz);
		
		Producto hawaiana = new Producto(null, "Hawaiana", new BigDecimal(11.90), 1, null, catPiz);

		prRep.save(pizSaturn);
		prcanRep.save(cantPizSaturn);

		prRep.save(margarita);
		prRep.save(carbonara);
		prRep.save(romana);
		prRep.save(barbacoa);
		prRep.save(cuaQueso);
		prRep.save(marinera);
		prRep.save(hawaiana);

		ProductoCategoria catEns = prcatRep.findByNombre("Ensaladas");
		Producto ensSat = new Producto(null, "Saturn", new BigDecimal(08.90), 1, null, catEns);
		Producto ensMix = new Producto(null, "Mixta", new BigDecimal(05.90), 1, null, catEns);
		Producto ensCes = new Producto(null, "Cesar", new BigDecimal(06.90), 1, null, catEns);
		Producto ensCap = new Producto(null, "Caprese", new BigDecimal(05.90), 1, null, catEns);
		Producto ensGri = new Producto(null, "Griega", new BigDecimal(06.90), 1, null, catEns);
		
		prRep.save(ensSat);
		prRep.save(ensMix);
		prRep.save(ensCes);
		prRep.save(ensCap);
		prRep.save(ensGri);

		ProductoCategoria catCom = prcatRep.findByNombre("Complementos");
		Producto metPollo = new Producto(null, "Meteoritos de pollo", new BigDecimal(03.90), 1, null, catCom);
		Producto alPollo = new Producto(null, "Alitas de pollo", new BigDecimal(03.90), 1, null, catCom);
		Producto metQueso = new Producto(null, "Meteoritos de queso", new BigDecimal(03.90), 1, null, catCom);
		Producto orbCeb = new Producto(null, "Órbitas de cebolla", new BigDecimal(01.90), 1, null, catCom);
		Producto rayPat = new Producto(null, "Rayos de patata", new BigDecimal(01.20), 1, null, catCom);
		Producto lunPat = new Producto(null, "Lunas de patata", new BigDecimal(01.90), 1, null, catCom);
		Producto comSat = new Producto(null, "Combo Saturn", new BigDecimal(04.90), 1, null, catCom);

		prRep.save(metPollo);
		prRep.save(alPollo);
		prRep.save(metQueso);
		prRep.save(orbCeb);
		prRep.save(rayPat);
		prRep.save(lunPat);
		prRep.save(comSat);

		ProductoCategoria catBeb = prcatRep.findByNombre("Bebidas");
		Producto coca = new Producto(null, "Coca Cola", new BigDecimal(01.90), 1, null, catBeb);
		Producto cocaZ = new Producto(null, "Coca Cola Zero", new BigDecimal(01.90), 1, null, catBeb);
		Producto kasNa = new Producto(null, "Kas naranja", new BigDecimal(01.90), 1, null, catBeb);
		Producto kasLi = new Producto(null, "Kas limón", new BigDecimal(01.90), 1, null, catBeb);
		Producto nest = new Producto(null, "Nestea 50cl", new BigDecimal(01.90), 1, null, catBeb);
		Producto sevUp = new Producto(null, "7up 50cl", new BigDecimal(01.90), 1, null, catBeb);
		Producto cerv = new Producto(null, "Cerveza Alhambra 33cl", new BigDecimal(01.90), 1, null, catBeb);
		Producto agua = new Producto(null, "Agua Font Vella 50cl", new BigDecimal(01.90), 1, null, catBeb);

		prRep.save(coca);
		prRep.save(cocaZ);
		prRep.save(kasNa);
		prRep.save(kasLi);
		prRep.save(nest);
		prRep.save(sevUp);
		prRep.save(cerv);
		prRep.save(agua);

		ProductoCategoria catPos = prcatRep.findByNombre("Postres");
		Producto choLun = new Producto(null, "Choco luna", new BigDecimal(04.90), 1, null, catPos);
		Producto plaLim = new Producto(null, "Planeta limón", new BigDecimal(04.40), 1, null, catPos);
		Producto helSat = new Producto(null, "Helado Saturn", new BigDecimal(04.90), 1, null, catPos);
		Producto tarQueso = new Producto(null, "Tarta de queso casera", new BigDecimal(04.90), 1, null, catPos);
		Producto flan = new Producto(null, "Flan casero", new BigDecimal(03.90), 1, null, catPos);
		Producto friPie = new Producto(null, "Frigo pié", new BigDecimal(01.20), 1, null, catPos);
		Producto crep = new Producto(null, "Crep de chocolate y nata", new BigDecimal(01.20), 1, null, catPos);

		prRep.save(choLun);
		prRep.save(plaLim);
		prRep.save(helSat);
		prRep.save(tarQueso);
		prRep.save(flan);
		prRep.save(friPie);
		prRep.save(crep);
	}

}
