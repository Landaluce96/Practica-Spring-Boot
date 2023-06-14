package com.landaluce.tienda.entity.model

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table

@Entity
@Table(name = "productos_carrito")
class ProductosCarrito implements Serializable{

    @EmbeddedId
    ProductosCarritoId id

    @ManyToOne
    @MapsId("carritoId")
    @JoinColumn(name = "carrito_id")
    Carrito carrito

    @ManyToOne
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    Producto producto

    @Column(nullable = false)
    Integer cantidad

}
