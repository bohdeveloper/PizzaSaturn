package com.bohdeveloper.pizzasaturn.entidades.usuarios;

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

    public Usuario(Long id, String username, String email, String password, Rol rol) {
        setId(id);
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setRol(rol);
    }

    public Usuario(Long id, String username, String email, String password1, String password2) {
        setId(id);
        setUsername(username);
        setEmail(email);
        setPassword1(password1);
        setPassword(password2);
    }

    public Usuario(String username, String email, String password, Rol rol) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setRol(rol);
    }

    public Usuario(Long id, String username, String email, String password) {
        setId(id);
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

}
