package com.landaluce.tienda.service.repository

import com.landaluce.tienda.entity.model.Producto
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

import static com.landaluce.tienda.datos.Dummy.*
import static com.landaluce.tienda.entity.model.enums.Categoria.*

@DataJpaTest
class ProductoRepositoryTest {

    @Autowired
    ProductoRepository productoRepository

    @BeforeEach
    void setUp() {
        def productos = [producto01, producto02, producto03]
        productoRepository.saveAll(productos)
    }

    @Test
    void testFindByCategoria() {
        List<Producto> expected = productoRepository.findByCategoria(ELECTRONICA)
        assert expected.size() == 2
    }

    @Test
    void testFindByNombreIgnoreCaseLike() {
        List<Producto> expected = productoRepository.buscarPorNombreLike("p")
        assert expected.size() == 2
    }

    @Test
    void testFindByNombreIgnoreCase() {
        Producto expected = productoRepository.findByNombreIgnoreCase("pan").get()
        assert expected.nombre == producto01.nombre
    }
}
