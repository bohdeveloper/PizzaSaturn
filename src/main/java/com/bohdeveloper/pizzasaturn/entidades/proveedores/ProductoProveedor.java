package com.bohdeveloper.pizzasaturn.entidades.proveedores;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos_proveedores")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductoProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String nombre;

    @Basic(optional = false)
    private BigDecimal precio;

    @ManyToOne(optional = false)
    private Proveedor proveedor;

}
