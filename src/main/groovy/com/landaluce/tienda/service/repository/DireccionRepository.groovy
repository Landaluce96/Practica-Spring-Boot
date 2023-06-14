package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Direccion
import org.springframework.data.repository.CrudRepository

interface DireccionRepository extends CrudRepository<Direccion, Integer>{

    Iterable<Direccion> findByClienteId(Integer id)
    Iterable<Direccion> findByClienteEmailIgnoreCase(String email)

}