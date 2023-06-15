package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Cliente
import com.landaluce.tienda.entity.model.Compra
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

import static org.junit.jupiter.api.Assertions.*
import static com.landaluce.tienda.datos.Dummy.*

@DataJpaTest
class CompraRepositoryTest {

    @Autowired
    CompraRepository compraRepository
    @Autowired
    ClienteRepository clienteRepository

    @BeforeEach
    void setUp() {
        Cliente cliente = clienteRepository.save(cliente01)
        Compra compra1 = compra01
        compra1.cliente = cliente
        Compra compra2 = compra02
        compra2.cliente = cliente
        Compra compra3 = compra03
        compra3.cliente = cliente
        def compras = [compra1, compra2, compra3]
        compraRepository.saveAll(compras)
    }

    @Test
    void findByClienteId() {
        List<Compra> expected = compraRepository.findByClienteId(1)
        assertEquals(expected.size(), 3)
    }

    @Test
    void findByClienteEmailIgnoreCase() {
        List<Compra> expected = compraRepository.findByClienteEmailIgnoreCase('alvaro@example.com')
        assertEquals(expected.size(), 3)
    }
}