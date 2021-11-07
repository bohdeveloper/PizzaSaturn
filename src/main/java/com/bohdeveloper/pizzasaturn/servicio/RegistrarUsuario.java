package com.bohdeveloper.pizzasaturn.servicio;

import com.bohdeveloper.pizzasaturn.dal.Dao;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Rol;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"usuario"})
public class RegistrarUsuario {

    @Autowired
    private Dao<Usuario> daoUsuario;

    @RequestMapping(value = "registroUsuario", method = RequestMethod.POST)
    public String registroUsuario(Usuario postUsuario, Model model) {

        String username = postUsuario.getUsername();
        String email = postUsuario.getEmail();
        String password = postUsuario.getPassword();
        String password1 = postUsuario.getPassword1();
        String password2 = postUsuario.getPassword2();
        Rol rol = postUsuario.getRol();

        Usuario usuario = new Usuario(username, email, password, password1, password2, rol);

        if (usuario.getErrores().size() != 0) {

            model.addAttribute("usuario", usuario);
            model.addAttribute("mensaje", "Tienes errores en el formulario");
            model.addAttribute("tipo", "danger");
            return "registro";

        } else {

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            String encodePassword = passwordEncoder.encode(password2);

            usuario.setPassword(encodePassword);

            daoUsuario.insertar(usuario);

            model.addAttribute("mensaje", "¡Te has registrado!, entra y disfruta");
            model.addAttribute("tipo", "info");
            return "login";
        }

    }

}
