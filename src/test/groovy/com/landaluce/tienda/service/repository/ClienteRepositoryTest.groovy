package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Cliente
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import static com.landaluce.tienda.datos.Dummy.*;

@DataJpaTest
class ClienteRepositoryTest {

    @Autowired
    ClienteRepository clienteRepository

    @BeforeEach
    void setUp() {
        clienteRepository.save(cliente01)
        clienteRepository.save(cliente02)
        clienteRepository.save(cliente03)
    }

    @Test
    void findByEmailIgnoreCase() {
        Cliente expected = clienteRepository.findByEmailIgnoreCase("alvaro@example.com").get()
        assertEquals(expected.email, cliente01.email)
    }

    @Test
    void findByNombreLikeIgnoreCaseOrApellidosLikeIgnoreCase() {
        List<Cliente> expected = (List<Cliente>)clienteRepository.buscarPorNombreApellidos("ri")
        assertEquals(expected.size(), 2)
        assertEquals(expected.get(0).nombre, cliente02.nombre)
    }

    @Test
    void findByTelefono() {
        Cliente expected = clienteRepository.findByTelefono("999999998").get()
        assertEquals(expected.telefono, cliente03.telefono)
    }
}
