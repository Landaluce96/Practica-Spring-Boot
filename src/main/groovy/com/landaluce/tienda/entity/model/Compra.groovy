package com.landaluce.tienda.entity.model

import groovy.transform.EqualsAndHashCode
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import jakarta.persistence.Table

import java.time.LocalDateTime

@Entity
@Table(name = "compras")
@EqualsAndHashCode(includes = "id")
class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @Column(nullable = false)
    BigDecimal total

    @Column(name = "fecha_realizacion")
    LocalDateTime fechaRealizacion

    @OneToMany(mappedBy = "compra")
    Set<ProductosCompra> productos

    @ManyToOne
    @JoinColumn(name = "direccion_id")
    Direccion direccion

    @ManyToOne
    @JoinColumn(name = "tarjeta_id")
    Tarjeta tarjeta

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente

    @PrePersist
    private void antesDePersistir(){
        this.fechaRealizacion = LocalDateTime.now();
    }

}
