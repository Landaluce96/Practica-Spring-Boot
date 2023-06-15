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
@Table(name = "direcciones")
@EqualsAndHashCode(includes = "id")
class Direccion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @Column(nullable = false, length = 50)
    String calle

    @Column(length = 4)
    String numero

    @Column(length = 4)
    String piso

    @Column(nullable = false, length = 6)
    String codigo

    @Column(nullable = false)
    String localidad

    @Column(name = "fecha_alta")
    LocalDateTime fechaAlta

    @Column(name = "fecha_modificacion")
    LocalDateTime fechaModificacion

    @OneToMany(mappedBy = "direccion")
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
