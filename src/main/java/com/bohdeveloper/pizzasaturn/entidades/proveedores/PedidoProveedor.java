package com.bohdeveloper.pizzasaturn.entidades.proveedores;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bohdeveloper.pizzasaturn.entidades.sucursales.Producto;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.Sucursal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PedidoProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private int cant_producto;
    
    @Basic(optional = false)
    private BigDecimal precio_total;

    @Basic(optional = false)
    private LocalDate f_pedido;

    @ManyToOne(optional = false)
    private Producto producto;

    @ManyToOne(optional = false)
    private Sucursal sucursal;

    @ManyToMany(mappedBy = "pedidos")
    private List<Proveedor> proveedores;
    
}
