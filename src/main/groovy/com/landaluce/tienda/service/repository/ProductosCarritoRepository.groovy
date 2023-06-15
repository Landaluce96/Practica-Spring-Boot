package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.ProductosCarrito
import com.landaluce.tienda.entity.model.ProductosCarritoId
import org.springframework.data.repository.CrudRepository

interface ProductosCarritoRepository extends CrudRepository<ProductosCarrito, ProductosCarritoId>{

    Iterable<ProductosCarrito> findByCarritoClienteId(Integer id)

}