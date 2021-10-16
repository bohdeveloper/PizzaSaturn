package com.bohdeveloper.pizzasaturn;

import java.math.BigDecimal;

import com.bohdeveloper.pizzasaturn.entidades.sucursales.Inventario;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.Producto;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.ProductoCategoria;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Rol;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Usuario;
import com.bohdeveloper.pizzasaturn.repositorios.sucursales.ProductoCantidadRepository;
import com.bohdeveloper.pizzasaturn.repositorios.sucursales.ProductoCategoriaRepository;
import com.bohdeveloper.pizzasaturn.repositorios.sucursales.ProductoRepository;
import com.bohdeveloper.pizzasaturn.repositorios.usuarios.RolRepository;
import com.bohdeveloper.pizzasaturn.repositorios.usuarios.UsuarioRepository;

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
		// Pizzas
		ProductoCategoria catPiz = prcatRep.findByNombre("Pizzas");
		Producto pizSat = new Producto(null, "Pizza Saturn", new BigDecimal(12.90), 1, null, catPiz);
		Inventario cantPizSat = new Inventario(null, "Pizza Saturn", 10, pizSat);

		Producto pizMar = new Producto(null, "Pizza margarita", new BigDecimal(09.90), 1, null, catPiz);
		Inventario cantPizMar = new Inventario(null, "Pizza margarita", 10, pizMar);

		Producto pizCar = new Producto(null, "Pizza carbonara", new BigDecimal(12.90), 1, null, catPiz);
		Inventario cantPizCar = new Inventario(null, "Pizza carbonara", 10, pizCar);

		Producto pizRom = new Producto(null, "Pizza romana", new BigDecimal(10.90), 1, null, catPiz);
		Inventario cantPizRom = new Inventario(null, "Pizza romana", 10, pizRom);

		Producto pizBar = new Producto(null, "Pizza barbacoa", new BigDecimal(12.90), 1, null, catPiz);
		Inventario cantPizBar = new Inventario(null, "Pizza barbacoa", 10, pizBar);

		Producto pizCua = new Producto(null, "Pizza cuatro quesos", new BigDecimal(12.90), 1, null, catPiz);
		Inventario cantPizCua = new Inventario(null, "Pizza Cuatro quesos", 10, pizCua);

		Producto pizMarin = new Producto(null, "Pizza marinera", new BigDecimal(10.90), 1, null, catPiz);
		Inventario cantPizMarin = new Inventario(null, "Pizza marinera", 10, pizMarin);
		
		Producto pizHaw = new Producto(null, "Pizza hawaiana", new BigDecimal(11.90), 1, null, catPiz);
		Inventario cantPizHaw = new Inventario(null, "Pizza hawaiana", 10, pizHaw);

		prRep.save(pizSat);
		prcanRep.save(cantPizSat);

		prRep.save(pizMar);
		prcanRep.save(cantPizMar);

		prRep.save(pizCar);
		prcanRep.save(cantPizCar); 

		prRep.save(pizRom);
		prcanRep.save(cantPizRom);

		prRep.save(pizBar);
		prcanRep.save(cantPizBar);

		prRep.save(pizCua);
		prcanRep.save(cantPizCua);

		prRep.save(pizMarin);
		prcanRep.save(cantPizMarin);

		prRep.save(pizHaw);
		prcanRep.save(cantPizHaw);

		// Ensaladas
		ProductoCategoria catEns = prcatRep.findByNombre("Ensaladas");
		Producto ensSat = new Producto(null, "Saturn", new BigDecimal(08.90), 1, null, catEns);
		Inventario cantEnsSat = new Inventario(null, "Ensalada Saturn", 10, ensSat);

		Producto ensMix = new Producto(null, "Mixta", new BigDecimal(05.90), 1, null, catEns);
		Inventario cantEnsMix = new Inventario(null, "Ensalada mixta", 10, ensMix);

		Producto ensCes = new Producto(null, "Cesar", new BigDecimal(06.90), 1, null, catEns);
		Inventario cantEnsCes = new Inventario(null, "Ensalada Cesar", 10, ensCes);

		Producto ensCap = new Producto(null, "Caprese", new BigDecimal(05.90), 1, null, catEns);
		Inventario cantEnsCap = new Inventario(null, "Ensalada caprese", 10, ensCap);

		Producto ensGri = new Producto(null, "Griega", new BigDecimal(06.90), 1, null, catEns);
		Inventario cantEnsGri = new Inventario(null, "Ensalada griega", 10, ensGri);

		prRep.save(ensSat);
		prcanRep.save(cantEnsSat);

		prRep.save(ensMix);
		prcanRep.save(cantEnsMix);

		prRep.save(ensCes);
		prcanRep.save(cantEnsCes);

		prRep.save(ensCap);
		prcanRep.save(cantEnsCap);

		prRep.save(ensGri);
		prcanRep.save(cantEnsGri);
		
		// Complementos
		ProductoCategoria catCom = prcatRep.findByNombre("Complementos");
		Producto metPollo = new Producto(null, "Meteoritos de pollo", new BigDecimal(03.90), 1, null, catCom);
		Inventario cantMetPollo = new Inventario(null, "Meteoritos de pollo", 10, metPollo);

		Producto alPollo = new Producto(null, "Alitas de pollo", new BigDecimal(03.90), 1, null, catCom);
		Inventario cantAlPollo = new Inventario(null, "Alitas de pollo", 10, alPollo);

		Producto metQueso = new Producto(null, "Meteoritos de queso", new BigDecimal(03.90), 1, null, catCom);
		Inventario cantMetQueso = new Inventario(null, "Meteoritos de queso", 10, metQueso);

		Producto orbCeb = new Producto(null, "Órbitas de cebolla", new BigDecimal(01.90), 1, null, catCom);
		Inventario cantOrbCeb = new Inventario(null, "Órbitas de cebolla", 10, orbCeb);

		Producto rayPat = new Producto(null, "Rayos de patata", new BigDecimal(01.20), 1, null, catCom);
		Inventario cantRayPat = new Inventario(null, "Rayos de patata", 10, rayPat);

		Producto lunPat = new Producto(null, "Lunas de patata", new BigDecimal(01.90), 1, null, catCom);
		Inventario cantLunPat = new Inventario(null, "Lunas de patata", 10, lunPat);

		Producto comSat = new Producto(null, "Combo Saturn", new BigDecimal(04.90), 1, null, catCom);
		Inventario cantComSat = new Inventario(null, "Combo Saturn", 10, comSat);

		prRep.save(metPollo);
		prcanRep.save(cantMetPollo);

		prRep.save(alPollo);
		prcanRep.save(cantAlPollo);

		prRep.save(metQueso);
		prcanRep.save(cantMetQueso);

		prRep.save(orbCeb);
		prcanRep.save(cantOrbCeb);

		prRep.save(rayPat);
		prcanRep.save(cantRayPat);

		prRep.save(lunPat);
		prcanRep.save(cantLunPat);

		prRep.save(comSat);
		prcanRep.save(cantComSat);

		// Bebidas
		ProductoCategoria catBeb = prcatRep.findByNombre("Bebidas");
		Producto coca = new Producto(null, "Coca Cola", new BigDecimal(01.90), 1, null, catBeb);
		Inventario cantCoca = new Inventario(null, "Coca Cola", 10, coca);

		Producto cocaZ = new Producto(null, "Coca Cola Zero", new BigDecimal(01.90), 1, null, catBeb);
		Inventario cantCocaZ = new Inventario(null, "Coca Cola Zero", 10, cocaZ);

		Producto kasNa = new Producto(null, "Kas naranja", new BigDecimal(01.90), 1, null, catBeb);
		Inventario cantKasNa = new Inventario(null, "Kas naranja", 10, kasNa);

		Producto kasLi = new Producto(null, "Kas limón", new BigDecimal(01.90), 1, null, catBeb);
		Inventario cantKasLi = new Inventario(null, "Kas limón", 10, kasLi);

		Producto nest = new Producto(null, "Nestea 50cl", new BigDecimal(01.90), 1, null, catBeb);
		Inventario cantNest = new Inventario(null, "Nestea 50cl", 10, nest);

		Producto sevUp = new Producto(null, "7up 50cl", new BigDecimal(01.90), 1, null, catBeb);
		Inventario cantSevUp = new Inventario(null, "7up 50cl", 10, sevUp);

		Producto cerv = new Producto(null, "Cerveza Alhambra 33cl", new BigDecimal(01.90), 1, null, catBeb);
		Inventario cantCerv = new Inventario(null, "Cerveza Alhambra 33cl", 10, cerv);

		Producto agua = new Producto(null, "Agua Font Vella 50cl", new BigDecimal(01.90), 1, null, catBeb);
		Inventario cantAgua = new Inventario(null, "Agua Font Vella 50cl", 10, agua);

		prRep.save(coca);
		prcanRep.save(cantCoca);

		prRep.save(cocaZ);
		prcanRep.save(cantCocaZ);

		prRep.save(kasNa);
		prcanRep.save(cantKasNa);
		
		prRep.save(kasLi);
		prcanRep.save(cantKasLi);

		prRep.save(nest);
		prcanRep.save(cantNest);
		
		prRep.save(sevUp);
		prcanRep.save(cantSevUp);

		prRep.save(cerv);
		prcanRep.save(cantCerv);

		prRep.save(agua);
		prcanRep.save(cantAgua);
		
		// Postres
		ProductoCategoria catPos = prcatRep.findByNombre("Postres");
		Producto choLun = new Producto(null, "Choco luna", new BigDecimal(04.90), 1, null, catPos);
		Inventario cantChoLun = new Inventario(null, "Choco luna", 10, choLun);

		Producto plaLim = new Producto(null, "Planeta limón", new BigDecimal(04.40), 1, null, catPos);
		Inventario cantPlaLim = new Inventario(null, "Planeta limón", 10, plaLim);

		Producto helSat = new Producto(null, "Helado Saturn", new BigDecimal(04.90), 1, null, catPos);
		Inventario cantHelSat = new Inventario(null, "Helado Saturn", 10, helSat);

		Producto tarQueso = new Producto(null, "Tarta de queso casera", new BigDecimal(04.90), 1, null, catPos);
		Inventario cantTarQueso = new Inventario(null, "Tarta de queso casera", 10, tarQueso);

		Producto flan = new Producto(null, "Flan casero", new BigDecimal(03.90), 1, null, catPos);
		Inventario cantFlan = new Inventario(null, "Flan casero", 10, flan);

		Producto friPie = new Producto(null, "Frigo pié", new BigDecimal(01.20), 1, null, catPos);
		Inventario cantFriPie = new Inventario(null, "Agua Font Vella 50cl", 10, friPie);

		Producto crep = new Producto(null, "Crep de chocolate y nata", new BigDecimal(01.20), 1, null, catPos);
		Inventario cantCrep = new Inventario(null, "Crep de chocolate y nata", 10, crep);

		prRep.save(choLun);
		prcanRep.save(cantChoLun);

		prRep.save(plaLim);
		prcanRep.save(cantPlaLim);

		prRep.save(helSat);
		prcanRep.save(cantHelSat);

		prRep.save(tarQueso);
		prcanRep.save(cantTarQueso);

		prRep.save(flan);
		prcanRep.save(cantFlan);

		prRep.save(friPie);
		prcanRep.save(cantFriPie);

		prRep.save(crep);
		prcanRep.save(cantCrep);

	}

}
