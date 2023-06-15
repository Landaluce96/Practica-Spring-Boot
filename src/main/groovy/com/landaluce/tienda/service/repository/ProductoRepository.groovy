package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Cliente
import com.landaluce.tienda.entity.model.Producto
import com.landaluce.tienda.entity.model.enums.Categoria
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ProductoRepository extends CrudRepository<Producto, Integer> {

    Iterable<Producto> findByCategoria(Categoria categoria)
    @Query(value = "SELECT * FROM productos WHERE LOWER(nombre) LIKE CONCAT('%', LOWER(?1), '%')", nativeQuery = true)
    Iterable<Producto> buscarPorNombreLike(String nombre)
    Optional<Producto> findByNombreIgnoreCase(String nombre)

}
