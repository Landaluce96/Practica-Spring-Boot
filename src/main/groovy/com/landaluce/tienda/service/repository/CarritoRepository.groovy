package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Carrito
import com.landaluce.tienda.entity.model.Cliente
import org.springframework.data.repository.CrudRepository

interface CarritoRepository extends CrudRepository<Carrito, Integer>{

}