package com.bohdeveloper.pizzasaturn.servicio;

import com.bohdeveloper.pizzasaturn.dal.Dao;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrarUsuario {

    @Autowired
    private Dao<Usuario> daoUsuario;

    @RequestMapping(value = "registroUsuario", method = RequestMethod.POST)
    public String registroUsuario(Usuario postUsuario) {

        String password1 = postUsuario.getPassword1();
        String password2 = postUsuario.getPassword2();

        if (password1.equals(password2)) {

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            String encodePassword = passwordEncoder.encode(password2);

            System.out.println(postUsuario.getRol());

            Usuario usuario = new Usuario(postUsuario.getUsername(), postUsuario.getEmail(), encodePassword, 
                    postUsuario.getRol());

            daoUsuario.insertar(usuario);

            System.out.println("Registro completo");
            return "login";
        } else {
            System.out.println("Contraseña incorrecta");
            return "registro";
        }

    }

}
