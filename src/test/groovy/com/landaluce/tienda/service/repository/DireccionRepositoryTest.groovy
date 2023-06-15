package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Cliente
import com.landaluce.tienda.entity.model.Direccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import static com.landaluce.tienda.datos.Dummy.*

@DataJpaTest
class DireccionRepositoryTest {

    @Autowired
    DireccionRepository direccionRepository
    @Autowired
    ClienteRepository clienteRepository

    @BeforeEach
    void setUp() {
        Cliente cliente = clienteRepository.save(cliente01)
        Direccion direccion1 = direccion01
        direccion1.cliente = cliente
        Direccion direccion2 = direccion02
        direccion2.cliente = cliente
        Direccion direccion3 = direccion03
        direccion3.cliente = cliente
        def direcciones = [direccion1, direccion2, direccion3]
        direccionRepository.saveAll(direcciones)
    }

    @Test
    void findByClienteId() {
        List<Direccion> expected = direccionRepository.findByClienteId(1)
        assertEquals(expected.size(), 3)
    }

    @Test
    void findByClienteEmailIgnoreCase() {
        List<Direccion> expected = direccionRepository.findByClienteEmailIgnoreCase('alvaro@example.com')
        assertEquals(expected.size(), 3)
    }
}