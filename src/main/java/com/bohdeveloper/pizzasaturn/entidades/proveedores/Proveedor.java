package com.bohdeveloper.pizzasaturn.entidades.proveedores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "proveedores")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String nombre;

    @Basic(optional = false)
    private Long telefono1;

    @Basic(optional = true)
    private Long telefono2;

    @Basic(optional = true)
    private String email;

    @Basic(optional = false)
    private String direccion;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<PedidoProveedor> pedidos;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "proveedor")
    private List<ProductoProveedor> productos = new ArrayList<>();
}
