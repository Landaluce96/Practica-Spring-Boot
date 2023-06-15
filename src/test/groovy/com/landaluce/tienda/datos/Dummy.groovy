package com.landaluce.tienda.datos

import com.landaluce.tienda.entity.model.Cliente
import com.landaluce.tienda.entity.model.Compra
import com.landaluce.tienda.entity.model.Direccion
import com.landaluce.tienda.entity.model.Producto
import com.landaluce.tienda.entity.model.Tarjeta
import com.landaluce.tienda.entity.model.enums.Categoria

import java.time.LocalDate

import static com.landaluce.tienda.entity.model.enums.Categoria.*

class Dummy {

    static final Cliente cliente01 = new Cliente(
            nombre: "Alvaro",
            apellidos: "Landaluce",
            email: "alvaro@example.com",
            telefono: "999999999",
            nacimiento: LocalDate.of(1996, 8, 14)
    )

    static final Cliente cliente02 = new Cliente(
            nombre: "Jorge",
            apellidos: "Rodriguez",
            email: "jorge@example.com",
            telefono: "999999989",
            nacimiento: LocalDate.of(1996, 8, 14)
    )

    static final Cliente cliente03 = new Cliente(
            nombre: "Maria",
            apellidos: "Perez",
            email: "maria@example.com",
            telefono: "999999998",
            nacimiento: LocalDate.of(1996, 8, 14)
    )

    static final Direccion direccion01 = new Direccion(
            calle: 'inventada',
            codigo: '28037',
            localidad: 'Madrid'
    )

    static final Direccion direccion02 = new Direccion(
            calle: 'nueva',
            codigo: '28022',
            localidad: 'Madrid'
    )

    static final Direccion direccion03 = new Direccion(
            calle: 'vieja',
            codigo: '28017',
            localidad: 'Madrid'
    )

    static final Tarjeta tarjeta01 = new Tarjeta(
            numero: '1111111111111111',
            caducidad: LocalDate.of(2024, 5, 1),
            titular: 'JORGE GIMENEZ PEREZ'
    )

    static final Tarjeta tarjeta02 = new Tarjeta(
            numero: '1111111111111222',
            caducidad: LocalDate.of(2024, 6, 1),
            titular: 'ROBERTO GIMENEZ PEREZ'
    )

    static final Tarjeta tarjeta03 = new Tarjeta(
            numero: '1111111111111333',
            caducidad: LocalDate.of(2025, 9, 1),
            titular: 'CARLOS GOMEZ PEREZ'
    )

    static final Compra compra01 = new Compra(
            total: 0.0
    )

    static final Compra compra02 = new Compra(
            total: 0.0
    )

    static final Compra compra03 = new Compra(
            total: 0.0
    )

    static final Producto producto01 = new Producto(
            nombre: "Pan",
            precio: 0.45,
            stock: 50,
            categoria: ALIMENTACION
    )

    static final Producto producto02 = new Producto(
            nombre: "portatil",
            precio: 400,
            stock: 50,
            categoria: ELECTRONICA
    )

    static final Producto producto03 = new Producto(
            nombre: "Raton",
            precio: 10,
            stock: 500,
            categoria: ELECTRONICA
    )

}
