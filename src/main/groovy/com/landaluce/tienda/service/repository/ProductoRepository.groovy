package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Cliente
import com.landaluce.tienda.entity.model.Producto
import com.landaluce.tienda.entity.model.enums.Categoria
import org.springframework.data.repository.CrudRepository

interface ProductoRepository extends CrudRepository<Producto, Integer> {

    Iterable<Producto> findByCategoria(Categoria categoria)
    Iterable<Producto> findByNombreIgnoreCaseLike(String nombre)
    Optional<Producto> findByNombreIgnoreCase(String nombre)
    Iterable<Producto> findByCarritosCarritoCliente(Cliente cliente)
    Iterable<Producto> findByComprasCompraId(Integer id)

}
