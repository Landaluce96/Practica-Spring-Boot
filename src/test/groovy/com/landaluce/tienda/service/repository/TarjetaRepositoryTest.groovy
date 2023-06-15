package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Cliente
import com.landaluce.tienda.entity.model.Tarjeta
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

import static org.junit.jupiter.api.Assertions.*;
import static com.landaluce.tienda.datos.Dummy.*

@DataJpaTest
class TarjetaRepositoryTest {

    @Autowired
    TarjetaRepository tarjetaRepository
    @Autowired
    ClienteRepository clienteRepository

    @BeforeEach
    void setUp() {
        Cliente cliente = clienteRepository.save(cliente01)
        Tarjeta tarjeta1 = tarjeta01
        tarjeta1.cliente = cliente
        Tarjeta tarjeta2 = tarjeta02
        tarjeta2.cliente = cliente
        Tarjeta tarjeta3 = tarjeta03
        tarjeta3.cliente = cliente
        def tarjetas = [tarjeta1, tarjeta2, tarjeta3]
        tarjetaRepository.saveAll(tarjetas)
    }

    @Test
    void findByClienteId() {
        List<Tarjeta> expected = tarjetaRepository.findByClienteId(1)
        assertEquals(expected.size(), 3)
    }

    @Test
    void findByClienteEmailIgnoreCase() {
        List<Tarjeta> expected = tarjetaRepository.findByClienteEmailIgnoreCase('alvaro@example.com')
        assertEquals(expected.size(), 3)
    }
}