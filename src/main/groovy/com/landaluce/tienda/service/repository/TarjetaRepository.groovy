package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Tarjeta
import org.springframework.data.repository.CrudRepository

interface TarjetaRepository extends CrudRepository<Tarjeta, Integer>{

    Iterable<Tarjeta> findByClienteId(Integer id)
    Iterable<Tarjeta> findByClienteEmailIgnoreCase(String email)

}