package com.bohdeveloper.pizzasaturn.entidades.sucursales;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "almacenes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(optional = false)
    private Sucursal sucursal;
    @OneToMany(mappedBy = "productos")
    private List<ProductoCategoria> productos = new ArrayList<>();
}
