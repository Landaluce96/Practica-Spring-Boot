package com.landaluce.tienda.entity.model

import groovy.transform.EqualsAndHashCode
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table

import java.time.LocalDateTime

@Entity
@Table(name = "carritos")
@EqualsAndHashCode(includes = ["cliente"])
class Carrito implements Serializable{

    @Id
    @Column(name = "cliente_id")
    Integer clienteId

    @OneToOne
    @PrimaryKeyJoinColumn(name = "cliente_id")
    Cliente cliente

    @Column(nullable = false)
    BigDecimal total

    @Column(name = "facha_alta")
    LocalDateTime fechaAlta

    @Column(name = "fecha_modificacion")
    LocalDateTime fechaModificacion

    @OneToMany(mappedBy = "carrito")
    Set<ProductosCarrito> productos

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
        if (total == null)
            total = 0.0
    }

    @PreUpdate
    private void antesDeUpdate(){
        this.fechaModificacion = LocalDateTime.now();
    }

}
