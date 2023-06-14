package com.landaluce.tienda.entity.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class ProductosCompraId {

    @Column(name = "compra_id")
    Integer compraId
    @Column(name = "producto_id")
    Integer productoId

}