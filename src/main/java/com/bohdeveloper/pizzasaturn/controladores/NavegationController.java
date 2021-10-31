package com.bohdeveloper.pizzasaturn.controladores;

import javax.servlet.http.HttpServletRequest;

import com.bohdeveloper.pizzasaturn.dal.Dao;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegationController {

    @Autowired
    private Dao<Usuario> daoUsuario;

    @GetMapping("/")
    public String goIndex(HttpServletRequest request) {
        return "index";
    }

    @GetMapping("/tienda")
    public String goTienda(HttpServletRequest request) {

        Usuario usuario = new Usuario();
        Iterable<Usuario> usuarios = daoUsuario.obtenerTodos();

        request.setAttribute("usuario", usuario);
        request.setAttribute("usuarios", usuarios);
        return "tienda/index";
    }

    @GetMapping("/registro")
    public String goRegistro(HttpServletRequest request) {
        return "registro";
    }

    @GetMapping("/login")
    public String goLogin(HttpServletRequest request) {
        return "login";
    }

    @GetMapping("/contacto")
    public String goContacto(HttpServletRequest request) {
        return "contacto";
    }
}
