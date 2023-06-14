package com.landaluce.tienda.entity.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class ProductosCarritoId {

    @Column(name = "carrito_id")
    Integer carritoId
    @Column(name = "producto_id")
    Integer productoId

}