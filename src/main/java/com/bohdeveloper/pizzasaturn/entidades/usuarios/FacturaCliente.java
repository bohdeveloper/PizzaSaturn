package com.bohdeveloper.pizzasaturn.entidades.usuarios;

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

import com.bohdeveloper.pizzasaturn.entidades.sucursales.Empleado;
import com.bohdeveloper.pizzasaturn.entidades.sucursales.Producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "facturas_clientes")
@AllArgsConstructor
@NoArgsConstructor

public class FacturaCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private int cantidad;

    @Basic(optional = false)
    private BigDecimal precio_total;

    @Basic(optional = false)
    private LocalDate f_factura;

    @ManyToOne(optional = false)
    private Cliente cliente;

    @ManyToOne(optional = false)
    private Empleado empleado;

    @ManyToMany(mappedBy = "facturas")
    private List<Producto> productos;
}
