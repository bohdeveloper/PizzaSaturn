package com.bohdeveloper.pizzasaturn.controladores;

import javax.servlet.http.HttpServletRequest;

import com.bohdeveloper.pizzasaturn.entidades.usuarios.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegationController {

    @GetMapping("/")
    public String goIndex(HttpServletRequest request) {
        return "index";
    }

    @GetMapping("/tienda")
    public String goTienda(Usuario usuario, HttpServletRequest request) {
        request.setAttribute("usuario", usuario);
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
