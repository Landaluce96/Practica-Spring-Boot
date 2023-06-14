package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Cliente
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ClienteRepository extends CrudRepository<Cliente, Integer>{

    Optional<Cliente> findByEmailIgnoreCase(String email)
    @Query(value = "SELECT * FROM clientes WHERE nombre LIKE CONCAT('%',?1,'%') or apellidos LIKE CONCAT('%',?1,'%')", nativeQuery = true)
    Iterable<Cliente> buscarPorNombreApellidos(String nombreApelldos)
    Optional<Cliente> findByTelefono(String telefono)

}