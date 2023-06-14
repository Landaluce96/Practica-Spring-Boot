package com.landaluce.tienda.entity.model

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table


@Entity
@Table(name = "productos_compra")
class ProductosCompra implements Serializable{

    @EmbeddedId
    ProductosCompraId id

    @ManyToOne
    @MapsId("compraId")
    @JoinColumn(name = "compra_id")
    Compra compra

    @ManyToOne
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    Producto producto

    @Column(nullable = false)
    Integer cantidad

    @Column(nullable = false)
    BigDecimal precio

}
