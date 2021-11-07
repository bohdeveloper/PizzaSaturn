package com.bohdeveloper.pizzasaturn;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.bohdeveloper.pizzasaturn.entidades.sucursales.Almacen;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.Empleado;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.Inventario;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.Producto;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.ProductoCategoria;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.Sucursal;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Rol;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Usuario;
import com.bohdeveloper.pizzasaturn.repositorios.sucursales.AlmacenRepository;
import com.bohdeveloper.pizzasaturn.repositorios.sucursales.EmpleadoRepository;
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
	@Autowired
	private EmpleadoRepository emRep;

	@Override
	public void run(String... args) throws Exception {

		// Creación de roles de usuario
		roRep.save(new Rol(null, "ADMIN", null));
		roRep.save(new Rol(null, "USER", null));
		roRep.save(new Rol(null, "USERPRO", null));

		// Creación de usuarios
		Rol rolAdmin = roRep.findByNombre("ADMIN");
		Usuario admin = new Usuario("admin", "admin@pizzasaturn.com",
				"$2a$12$Jlz419IFeL3JNzraQIxdBe.1gaAOHUyw3PrV/eyd97lruJrvzaC.2", rolAdmin);

		Rol rolUser = roRep.findByNombre("USER");
		Usuario user = new Usuario("user", "user@pizzasaturn.com",
				"$2a$12$Jlz419IFeL3JNzraQIxdBe.1gaAOHUyw3PrV/eyd97lruJrvzaC.2", rolUser);

		Rol rolUserPro = roRep.findByNombre("USERPRO");
		Usuario userpro = new Usuario("userpro", "userpro@pizzasaturn.com",
				"$2a$12$Jlz419IFeL3JNzraQIxdBe.1gaAOHUyw3PrV/eyd97lruJrvzaC.2", rolUserPro);

		usRep.save(admin);
		usRep.save(user);
		usRep.save(userpro);

		// Creación de sucursales

		Sucursal sIr1 = new Sucursal(null, "Calle mayor 22, Irún, 20304", null, null, null, null, null);
		Sucursal sSa1 = new Sucursal(null, "Avenida de Madrid 9, San Sebastián, 20011", null, null, null, null, null);
		Sucursal sZa1 = new Sucursal(null, "Calle Gipuzkoa 6, Zarauz, 20800", null, null, null, null, null);

		suRep.save(sIr1);
		suRep.save(sSa1);
		suRep.save(sZa1);

		// Creación de almacenes
		Almacen aIr1 = new Almacen(null, "Básico", sIr1, null);
		Almacen aSa1 = new Almacen(null, "Básico", sSa1, null);
		Almacen aZa1 = new Almacen(null, "Básico", sZa1, null);

		alRep.save(aIr1);
		alRep.save(aSa1);
		alRep.save(aZa1);

		// Creación de empleados
		LocalDate f_inicio = LocalDate.parse("2021-10-18");
		LocalDate f_nacim = LocalDate.parse("1986-04-20");

		String male = "Male";
		char m = male.charAt(0);

		String female = "Fale";
		char f = female.charAt(0);

		Empleado Ir1 = new Empleado(null, 1, 658456879542L, "Tomás", "Garcia Ruiz", 653895647L, 943589652L,
				"tom.gr@gmail.com", f_inicio, f_nacim, 35, m, new BigDecimal(15860.50), sIr1, null, null);
		Empleado Ir2 = new Empleado(null, 2, 765432567281L, "Maria", "Fernandez Casas", 658999874L, 943658956L,
				"mariii25@gmail.com", f_inicio, f_nacim, 35, f, new BigDecimal(14560.50), sIr1, null, null);
		Empleado Sa1 = new Empleado(null, 1, 698521365425L, "Alberto", "Merino Ferrero", 654125896L, 943665215L,
				"albert788@hotmail.com", f_inicio, f_nacim, 35, m, new BigDecimal(12560.50), sSa1, null, null);
		Empleado Sa2 = new Empleado(null, 2, 121234567821L, "Silvia", "Martinez Otxoa", 689655233L, 943658457L,
				"8asilvia@gmail.com", f_inicio, f_nacim, 35, f, new BigDecimal(13660.50), sSa1, null, null);
		Empleado Za1 = new Empleado(null, 1, 158633224558L, "Arkaitz", "Sarasola Lopez", 632215689L, 943125689L,
				"arkanooSa12@yahoo.com", f_inicio, f_nacim, 35, m, new BigDecimal(15660.50), sZa1, null, null);
		Empleado Za2 = new Empleado(null, 1, 589645689265L, "Marta", "Muguruza Arocena", 699874652L, 943586452L,
				"mma.81@outlook.com", f_inicio, f_nacim, 35, f, new BigDecimal(12660.50), sZa1, null, null);

		emRep.save(Ir1);
		emRep.save(Ir2);
		emRep.save(Sa1);
		emRep.save(Sa2);
		emRep.save(Za1);
		emRep.save(Za2);

		// Creación de categorias para productos
		prcatRep.save(new ProductoCategoria(null, "Pizzas", null));
		prcatRep.save(new ProductoCategoria(null, "Ensaladas", null));
		prcatRep.save(new ProductoCategoria(null, "Complementos", null));
		prcatRep.save(new ProductoCategoria(null, "Bebidas", null));
		prcatRep.save(new ProductoCategoria(null, "Postres", null));

		// Creación de productos y sus cantidades en stock
		// Pizzas

		LocalDate f_cadu = LocalDate.parse("2021-12-20");

		ProductoCategoria catPiz = prcatRep.findByNombre("Pizzas");
		Producto pizSat = new Producto(null, "Pizza Saturn", new BigDecimal(12.90), 1, null, catPiz, null, null, null);
		Inventario cantPizSat = new Inventario(null, 10, f_cadu, pizSat);

		Producto pizMar = new Producto(null, "Pizza margarita", new BigDecimal(09.90), 1, null, catPiz, null, null,
				null);
		Inventario cantPizMar = new Inventario(null, 10, f_cadu, pizMar);

		Producto pizCar = new Producto(null, "Pizza carbonara", new BigDecimal(12.90), 1, null, catPiz, null, null,
				null);
		Inventario cantPizCar = new Inventario(null, 10, f_cadu, pizCar);

		Producto pizRom = new Producto(null, "Pizza romana", new BigDecimal(10.90), 1, null, catPiz, null, null, null);
		Inventario cantPizRom = new Inventario(null, 10, f_cadu, pizRom);

		Producto pizBar = new Producto(null, "Pizza barbacoa", new BigDecimal(12.90), 1, null, catPiz, null, null,
				null);
		Inventario cantPizBar = new Inventario(null, 10, f_cadu, pizBar);

		Producto pizCua = new Producto(null, "Pizza cuatro quesos", new BigDecimal(12.90), 1, null, catPiz, null, null,
				null);
		Inventario cantPizCua = new Inventario(null, 10, f_cadu, pizCua);

		Producto pizMarin = new Producto(null, "Pizza marinera", new BigDecimal(10.90), 1, null, catPiz, null, null,
				null);
		Inventario cantPizMarin = new Inventario(null, 10, f_cadu, pizMarin);

		Producto pizHaw = new Producto(null, "Pizza hawaiana", new BigDecimal(11.90), 1, null, catPiz, null, null,
				null);
		Inventario cantPizHaw = new Inventario(null, 10, f_cadu, pizHaw);

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
		Producto ensSat = new Producto(null, "Saturn", new BigDecimal(08.90), 1, null, catEns, null, null, null);
		Inventario cantEnsSat = new Inventario(null, 10, f_cadu, ensSat);

		Producto ensMix = new Producto(null, "Mixta", new BigDecimal(05.90), 1, null, catEns, null, null, null);
		Inventario cantEnsMix = new Inventario(null, 10, f_cadu, ensMix);

		Producto ensCes = new Producto(null, "Cesar", new BigDecimal(06.90), 1, null, catEns, null, null, null);
		Inventario cantEnsCes = new Inventario(null, 10, f_cadu, ensCes);

		Producto ensCap = new Producto(null, "Caprese", new BigDecimal(05.90), 1, null, catEns, null, null, null);
		Inventario cantEnsCap = new Inventario(null, 10, f_cadu, ensCap);

		Producto ensGri = new Producto(null, "Griega", new BigDecimal(06.90), 1, null, catEns, null, null, null);
		Inventario cantEnsGri = new Inventario(null, 10, f_cadu, ensGri);

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
		Producto metPollo = new Producto(null, "Meteoritos de pollo", new BigDecimal(03.90), 1, null, catCom, null,
				null, null);
		Inventario cantMetPollo = new Inventario(null, 10, f_cadu, metPollo);

		Producto alPollo = new Producto(null, "Alitas de pollo", new BigDecimal(03.90), 1, null, catCom, null, null,
				null);
		Inventario cantAlPollo = new Inventario(null, 10, f_cadu, alPollo);

		Producto metQueso = new Producto(null, "Meteoritos de queso", new BigDecimal(03.90), 1, null, catCom, null,
				null, null);
		Inventario cantMetQueso = new Inventario(null, 10, f_cadu, metQueso);

		Producto orbCeb = new Producto(null, "Órbitas de cebolla", new BigDecimal(01.90), 1, null, catCom, null, null,
				null);
		Inventario cantOrbCeb = new Inventario(null, 10, f_cadu, orbCeb);

		Producto rayPat = new Producto(null, "Rayos de patata", new BigDecimal(01.20), 1, null, catCom, null, null,
				null);
		Inventario cantRayPat = new Inventario(null, 10, f_cadu, rayPat);

		Producto lunPat = new Producto(null, "Lunas de patata", new BigDecimal(01.90), 1, null, catCom, null, null,
				null);
		Inventario cantLunPat = new Inventario(null, 10, f_cadu, lunPat);

		Producto comSat = new Producto(null, "Combo Saturn", new BigDecimal(04.90), 1, null, catCom, null, null, null);
		Inventario cantComSat = new Inventario(null, 10, f_cadu, comSat);

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
		Producto coca = new Producto(null, "Coca Cola", new BigDecimal(01.90), 1, null, catBeb, null, null, null);
		Inventario cantCoca = new Inventario(null, 10, f_cadu, coca);

		Producto cocaZ = new Producto(null, "Coca Cola Zero", new BigDecimal(01.90), 1, null, catBeb, null, null, null);
		Inventario cantCocaZ = new Inventario(null, 10, f_cadu, cocaZ);

		Producto kasNa = new Producto(null, "Kas naranja", new BigDecimal(01.90), 1, null, catBeb, null, null, null);
		Inventario cantKasNa = new Inventario(null, 10, f_cadu, kasNa);

		Producto kasLi = new Producto(null, "Kas limón", new BigDecimal(01.90), 1, null, catBeb, null, null, null);
		Inventario cantKasLi = new Inventario(null, 10, f_cadu, kasLi);

		Producto nest = new Producto(null, "Nestea 50cl", new BigDecimal(01.90), 1, null, catBeb, null, null, null);
		Inventario cantNest = new Inventario(null, 10, f_cadu, nest);

		Producto sevUp = new Producto(null, "7up 50cl", new BigDecimal(01.90), 1, null, catBeb, null, null, null);
		Inventario cantSevUp = new Inventario(null, 10, f_cadu, sevUp);

		Producto cerv = new Producto(null, "Cerveza Alhambra 33cl", new BigDecimal(01.90), 1, null, catBeb, null, null,
				null);
		Inventario cantCerv = new Inventario(null, 10, f_cadu, cerv);

		Producto agua = new Producto(null, "Agua Font Vella 50cl", new BigDecimal(01.90), 1, null, catBeb, null, null,
				null);
		Inventario cantAgua = new Inventario(null, 10, f_cadu, agua);

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
		Producto choLun = new Producto(null, "Choco luna", new BigDecimal(04.90), 1, null, catPos, null, null, null);
		Inventario cantChoLun = new Inventario(null, 10, f_cadu, choLun);

		Producto plaLim = new Producto(null, "Planeta limón", new BigDecimal(04.40), 1, null, catPos, null, null, null);
		Inventario cantPlaLim = new Inventario(null, 10, f_cadu, plaLim);

		Producto helSat = new Producto(null, "Helado Saturn", new BigDecimal(04.90), 1, null, catPos, null, null, null);
		Inventario cantHelSat = new Inventario(null, 10, f_cadu, helSat);

		Producto tarQueso = new Producto(null, "Tarta de queso casera", new BigDecimal(04.90), 1, null, catPos, null,
				null, null);
		Inventario cantTarQueso = new Inventario(null, 10, f_cadu, tarQueso);

		Producto flan = new Producto(null, "Flan casero", new BigDecimal(03.90), 1, null, catPos, null, null, null);
		Inventario cantFlan = new Inventario(null, 10, f_cadu, flan);

		Producto friPie = new Producto(null, "Frigo pié", new BigDecimal(01.20), 1, null, catPos, null, null, null);
		Inventario cantFriPie = new Inventario(null, 10, f_cadu, friPie);

		Producto crep = new Producto(null, "Crep de chocolate y nata", new BigDecimal(01.20), 1, null, catPos, null,
				null, null);
		Inventario cantCrep = new Inventario(null, 10, f_cadu, crep);

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
