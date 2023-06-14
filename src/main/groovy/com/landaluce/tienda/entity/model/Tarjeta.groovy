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

import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "tarjetas")
@EqualsAndHashCode(includes = ["id", "numero"])
class Tarjeta implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @Column(nullable = false, unique = true, length = 16)
    String numero

    @Column(nullable = false)
    LocalDate caducidad

    @Column(nullable = false, length = 100)
    String titular

    @Column(length = 3)
    String CVV

    @Column(name = "fecha_alta")
    LocalDateTime fechaAlta

    @Column(name = "fecha_modificacion")
    LocalDateTime fechaModificacion

    @OneToMany(mappedBy = "tarjeta")
    Set<Compra> compras

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void antesDeUpdate(){
        this.fechaModificacion = LocalDateTime.now();
    }

}
