package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.ProductosCarritoId
import com.landaluce.tienda.entity.model.ProductosCompra
import org.springframework.data.repository.CrudRepository

interface ProductosCompraRepository extends CrudRepository<ProductosCompra, ProductosCarritoId>{

    Iterable<ProductosCompra> findByCompraId(Integer id)

}