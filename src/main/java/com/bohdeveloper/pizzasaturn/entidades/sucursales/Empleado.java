package com.bohdeveloper.pizzasaturn.entidades.sucursales;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bohdeveloper.pizzasaturn.entidades.usuarios.FacturaCliente;
import com.bohdeveloper.pizzasaturn.entidades.usuarios.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Basic(optional = false)
    private int num_empleado;

    @Basic(optional = false)
    private Long num_segsocial;

    @Basic(optional = false)
    private String nombre;

    @Basic(optional = false)
    private String apellidos;

    @Basic(optional = false)
    private Long telefono1;

    @Basic(optional = true)
    private Long telefono2;

    @Basic(optional = false)
    private String email;

    @Basic(optional = false)
    private LocalDate f_inicio;

    @Basic(optional = false)
    private LocalDate f_nacim;

    @Basic(optional = false)
    private int edad;

    @Basic(optional = false)
    private char sexo;

    @Basic(optional = false)
    private BigDecimal sueldoAnu_br;
    
    @ManyToOne(optional = false)
    private Sucursal sucursal;

    @OneToOne(optional = true)
    private Usuario usuario;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "empleado")
    private List<FacturaCliente> facturas = new ArrayList<>();
}
