package com.bohdeveloper.pizzasaturn.entidades.usuarios;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String username;

    @Basic(optional = false)
    private String email;

    @Basic(optional = false)
    private String password;

    @JsonInclude()
    @Transient
    private String password1;

    @JsonInclude()
    @Transient
    private String password2;

    @ManyToOne(optional = false)
    private Rol rol;

    @JsonInclude()
    @Transient
    private TreeMap<String, String> errores = new TreeMap<>();

    public Usuario(Long id, String username, String email, String password) {
        setId(id);
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public Usuario(String username, String email, String password, Rol rol) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setRol(rol);
    }

    public Usuario(String username, String email, String password, String password1, String password2, Rol rol) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setPassword1(password1);
        setPassword2(password2);
        setRol(rol);
    }

    public void setUsername(String username) {
        if (username == null || username.trim().length() == 0) {
            errores.put("username", "Añade un nombre de usuario");
            return;
        }
        this.username = username;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().length() == 0) {
            errores.put("email", "Añade tu correo electrónico");
            return;
        }
        this.email = email;
    }

    public void setPassword1(String password1) {
        System.out.println("Recibiendo password1: " + password1);
        final String PATRON_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,12}$";
        final Pattern patron = Pattern.compile(PATRON_PASSWORD);
        Matcher matcher = patron.matcher(password1);
        System.out.println("Matcher password1: " + matcher.matches());
        if (matcher.matches() == true) {
            this.password1 = password1;
            System.out.println("Este password1: " + this.password1);

        } else {
            this.password1 = "";
            errores.put("password1",
                    "La contraseña debe tener entre 6 y 12 caracteres, con al menos un número, una mayúscula y una minúsculas");
            System.out.println("Errores: " + errores);

        }
    }

    public void setPassword2(String password2) {
        System.out.println("Recibiendo password2: " + password2);
        final String PATRON_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,12}$";
        final Pattern patron = Pattern.compile(PATRON_PASSWORD);
        Matcher matcher = patron.matcher(password2);
        System.out.println("Matcher password2: " + matcher.matches());
        if (matcher.matches() == true) {

            this.password2 = password2;
            System.out.println("Este password2: " + this.password2);

            if (this.password1.equals(this.password2)) {
                this.password = password2;
                System.out.println("Contraseñas iguales, contraseña final: " + this.password);
            } else {
                errores.put("password", "Las contraseñas no coinciden");
                System.out.println("Errores: " + errores);
            }

        } else {
            this.password2 = "";
            errores.put("password2",
                    "La contraseña debe tener entre 6 y 12 caracteres, con al menos un número, una mayúscula y una minúsculas");
            System.out.println("Errores: " + errores);
        }
    }

}
