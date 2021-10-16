package com.bohdeveloper.pizzasaturn;

import java.math.BigDecimal;

import com.bohdeveloper.pizzasaturn.entidades.sucursales.Almacen;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.Inventario;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.Producto;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.ProductoCategoria;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.Sucursal;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Rol;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Usuario;
import com.bohdeveloper.pizzasaturn.repositorios.sucursales.AlmacenRepository;
import com.bohdeveloper.pizzasaturn.repositorios.sucursales.ProductoCantidadRepository;
import com.bohdeveloper.pizzasaturn.repositorios.sucursales.ProductoCategoriaRepository;
import com.bohdeveloper.pizzasaturn.repositorios.sucursales.ProductoRepository;
import com.bohdeveloper.pizzasaturn.repositorios.sucursales.SucursalRepository;
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

	// Cargar repositorios
	// Usuario
	@Autowired
	private UsuarioRepository usRep;
	@Autowired
	private RolRepository roRep;
	/*
	 * @Autowired private ClienteRepository cRep;
	 */

	// Sucursal
	@Autowired
	private SucursalRepository suRep;
	@Autowired
	private AlmacenRepository alRep;
	@Autowired
	private ProductoRepository prRep;
	@Autowired
	private ProductoCategoriaRepository prcatRep;
	@Autowired
	private ProductoCantidadRepository prcanRep;

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

		// Creación de sucursales
		Sucursal sIr1 = new Sucursal(null, "Calle mayor 22, Irún, 20304", null);
		Sucursal sSa1 = new Sucursal(null, "Avenida de Madrid 9, San Sebastián, 20011", null);	
		Sucursal sZa1 = new Sucursal(null, "Calle Gipuzkoa 6, Zarauz, 20800", null);

		suRep.save(sIr1);
		suRep.save(sSa1);
		suRep.save(sZa1);

		// Creación de almacenes
		Almacen aIr1 = new Almacen(null, sIr1, null);
		Almacen aSa1 = new Almacen(null, sSa1, null);
		Almacen aZa1 = new Almacen(null, sZa1, null);

		alRep.save(aIr1);
		alRep.save(aSa1);
		alRep.save(aZa1);

		// Creación de categorias para productos
		prcatRep.save(new ProductoCategoria(null, "Pizzas", null));
		prcatRep.save(new ProductoCategoria(null, "Ensaladas", null));
		prcatRep.save(new ProductoCategoria(null, "Complementos", null));
		prcatRep.save(new ProductoCategoria(null, "Bebidas", null));
		prcatRep.save(new ProductoCategoria(null, "Postres", null));

		// Creación de productos y sus cantidades en stock
		// Pizzas
		ProductoCategoria catPiz = prcatRep.findByNombre("Pizzas");
		Producto pizSat = new Producto(null, "Pizza Saturn", new BigDecimal(12.90), 1, null, catPiz, null);
		Inventario cantPizSat = new Inventario(null, 10, pizSat, aIr1);

		Producto pizMar = new Producto(null, "Pizza margarita", new BigDecimal(09.90), 1, null, catPiz, null);
		Inventario cantPizMar = new Inventario(null, 10, pizMar, aIr1);

		Producto pizCar = new Producto(null, "Pizza carbonara", new BigDecimal(12.90), 1, null, catPiz, null);
		Inventario cantPizCar = new Inventario(null, 10, pizCar, aIr1);

		Producto pizRom = new Producto(null, "Pizza romana", new BigDecimal(10.90), 1, null, catPiz, null);
		Inventario cantPizRom = new Inventario(null, 10, pizRom, aIr1);

		Producto pizBar = new Producto(null, "Pizza barbacoa", new BigDecimal(12.90), 1, null, catPiz, null);
		Inventario cantPizBar = new Inventario(null, 10, pizBar, aIr1);

		Producto pizCua = new Producto(null, "Pizza cuatro quesos", new BigDecimal(12.90), 1, null, catPiz, null);
		Inventario cantPizCua = new Inventario(null, 10, pizCua, aIr1);

		Producto pizMarin = new Producto(null, "Pizza marinera", new BigDecimal(10.90), 1, null, catPiz, null);
		Inventario cantPizMarin = new Inventario(null, 10, pizMarin, aIr1);

		Producto pizHaw = new Producto(null, "Pizza hawaiana", new BigDecimal(11.90), 1, null, catPiz, null);
		Inventario cantPizHaw = new Inventario(null, 10, pizHaw, aIr1);

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
		Producto ensSat = new Producto(null, "Saturn", new BigDecimal(08.90), 1, null, catEns, null);
		Inventario cantEnsSat = new Inventario(null, 10, ensSat, aIr1);

		Producto ensMix = new Producto(null, "Mixta", new BigDecimal(05.90), 1, null, catEns, null);
		Inventario cantEnsMix = new Inventario(null, 10, ensMix, aIr1);

		Producto ensCes = new Producto(null, "Cesar", new BigDecimal(06.90), 1, null, catEns, null);
		Inventario cantEnsCes = new Inventario(null, 10, ensCes, aIr1);

		Producto ensCap = new Producto(null, "Caprese", new BigDecimal(05.90), 1, null, catEns, null);
		Inventario cantEnsCap = new Inventario(null, 10, ensCap, aIr1);

		Producto ensGri = new Producto(null, "Griega", new BigDecimal(06.90), 1, null, catEns, null);
		Inventario cantEnsGri = new Inventario(null, 10, ensGri, aIr1);

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
		Producto metPollo = new Producto(null, "Meteoritos de pollo", new BigDecimal(03.90), 1, null, catCom, null);
		Inventario cantMetPollo = new Inventario(null, 10, metPollo, aIr1);

		Producto alPollo = new Producto(null, "Alitas de pollo", new BigDecimal(03.90), 1, null, catCom, null);
		Inventario cantAlPollo = new Inventario(null, 10, alPollo, aIr1);

		Producto metQueso = new Producto(null, "Meteoritos de queso", new BigDecimal(03.90), 1, null, catCom, null);
		Inventario cantMetQueso = new Inventario(null, 10, metQueso, aIr1);

		Producto orbCeb = new Producto(null, "Órbitas de cebolla", new BigDecimal(01.90), 1, null, catCom, null);
		Inventario cantOrbCeb = new Inventario(null, 10, orbCeb, aIr1);

		Producto rayPat = new Producto(null, "Rayos de patata", new BigDecimal(01.20), 1, null, catCom, null);
		Inventario cantRayPat = new Inventario(null, 10, rayPat, aIr1);

		Producto lunPat = new Producto(null, "Lunas de patata", new BigDecimal(01.90), 1, null, catCom, null);
		Inventario cantLunPat = new Inventario(null, 10, lunPat, aIr1);

		Producto comSat = new Producto(null, "Combo Saturn", new BigDecimal(04.90), 1, null, catCom, null);
		Inventario cantComSat = new Inventario(null, 10, comSat, aIr1);

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
		Producto coca = new Producto(null, "Coca Cola", new BigDecimal(01.90), 1, null, catBeb, null);
		Inventario cantCoca = new Inventario(null, 10, coca, aIr1);

		Producto cocaZ = new Producto(null, "Coca Cola Zero", new BigDecimal(01.90), 1, null, catBeb, null);
		Inventario cantCocaZ = new Inventario(null, 10, cocaZ, aIr1);

		Producto kasNa = new Producto(null, "Kas naranja", new BigDecimal(01.90), 1, null, catBeb, null);
		Inventario cantKasNa = new Inventario(null, 10, kasNa, aIr1);

		Producto kasLi = new Producto(null, "Kas limón", new BigDecimal(01.90), 1, null, catBeb, null);
		Inventario cantKasLi = new Inventario(null, 10, kasLi, aIr1);

		Producto nest = new Producto(null, "Nestea 50cl", new BigDecimal(01.90), 1, null, catBeb, null);
		Inventario cantNest = new Inventario(null, 10, nest, aIr1);

		Producto sevUp = new Producto(null, "7up 50cl", new BigDecimal(01.90), 1, null, catBeb, null);
		Inventario cantSevUp = new Inventario(null, 10, sevUp, aIr1);

		Producto cerv = new Producto(null, "Cerveza Alhambra 33cl", new BigDecimal(01.90), 1, null, catBeb, null);
		Inventario cantCerv = new Inventario(null, 10, cerv, aIr1);

		Producto agua = new Producto(null, "Agua Font Vella 50cl", new BigDecimal(01.90), 1, null, catBeb, null);
		Inventario cantAgua = new Inventario(null, 10, agua, aIr1);

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
		Producto choLun = new Producto(null, "Choco luna", new BigDecimal(04.90), 1, null, catPos, null);
		Inventario cantChoLun = new Inventario(null, 10, choLun, aIr1);

		Producto plaLim = new Producto(null, "Planeta limón", new BigDecimal(04.40), 1, null, catPos, null);
		Inventario cantPlaLim = new Inventario(null, 10, plaLim, aIr1);

		Producto helSat = new Producto(null, "Helado Saturn", new BigDecimal(04.90), 1, null, catPos, null);
		Inventario cantHelSat = new Inventario(null, 10, helSat, aIr1);

		Producto tarQueso = new Producto(null, "Tarta de queso casera", new BigDecimal(04.90), 1, null, catPos, null);
		Inventario cantTarQueso = new Inventario(null, 10, tarQueso, aIr1);

		Producto flan = new Producto(null, "Flan casero", new BigDecimal(03.90), 1, null, catPos, null);
		Inventario cantFlan = new Inventario(null, 10, flan, aIr1);

		Producto friPie = new Producto(null, "Frigo pié", new BigDecimal(01.20), 1, null, catPos, null);
		Inventario cantFriPie = new Inventario(null, 10, friPie, aIr1);

		Producto crep = new Producto(null, "Crep de chocolate y nata", new BigDecimal(01.20), 1, null, catPos, null);
		Inventario cantCrep = new Inventario(null, 10, crep, aIr1);

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
