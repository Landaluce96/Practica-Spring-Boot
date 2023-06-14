package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Compra
import org.springframework.data.repository.CrudRepository

interface CompraRepository extends CrudRepository<Compra, Integer>{

    Iterable<Compra> findByClienteId(Integer id)
    Iterable<Compra> findByClienteEmailIgnoreCase(String email)

}