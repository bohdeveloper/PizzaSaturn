package com.bohdeveloper.pizzasaturn.entidades.usuarios;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor

public class Cliente{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    private String apellidos;
    @Basic(optional = true)
    private String empresa;
    @Basic(optional = false)
    private String direccion;
    @Basic(optional = false)
    private String poblacion;
    @Basic(optional = true)
    private String ult_compra;
    @Basic(optional = false)
    private LocalDate f_nacim;
    @Basic(optional = true)
    private char sexo;

    @OneToOne(optional = false)
    private Usuario usuario;

}
