package com.bohdeveloper.pizzasaturn.entidades.sucursales;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre del producto es obligatorio")
    @Basic(optional = false)
    private String nombre;

    @Basic(optional = false)
    private BigDecimal precio;

    @Basic(optional = false)
    private int disponible;

    @Basic(optional = true)
    private String ImagenUrl;

    @ManyToOne(optional = false)
    private ProductoCategoria prod_cat;
    
    @ManyToOne(optional = true)
    private Almacen almacen;
    
}
