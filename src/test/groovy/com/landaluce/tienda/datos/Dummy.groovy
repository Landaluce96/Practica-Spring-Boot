package com.landaluce.tienda.datos

import com.landaluce.tienda.entity.model.Cliente

import java.time.LocalDate

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

}
