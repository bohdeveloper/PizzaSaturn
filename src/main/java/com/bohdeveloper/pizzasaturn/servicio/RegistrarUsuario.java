package com.bohdeveloper.pizzasaturn.servicio;

import com.bohdeveloper.pizzasaturn.entidades.usuarios.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrarUsuario {

    @RequestMapping(value = "registroUsuario", method = RequestMethod.POST)
    public String registroUsuario(Usuario usuario) {

        System.out.println(usuario.getUsername() + " " + usuario.getPassword1() + " " + usuario.getPassword2() + " " + usuario.getEmail());

        return "login.html";

        /*         Usuario usuario = new usuario(username, );

        return "registro.html";

        return "login.html"; */
    }

}
