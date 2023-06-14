package com.landaluce.tienda.entity.model

import com.landaluce.tienda.entity.model.enums.Categoria
import groovy.transform.EqualsAndHashCode
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import jakarta.persistence.Table

import java.time.LocalDateTime

@Entity
@Table(name = "productos")
@EqualsAndHashCode(includes = ["id", "nombre"])
class Producto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @Column(nullable = false, unique = true)
    String nombre

    @Column(nullable = false)
    BigDecimal precio

    @Column(nullable = false)
    Integer stock

    Categoria categoria

    @Column(name = "fecha_alta")
    LocalDateTime fechaAlta

    @Column(name = "fecha_modificacion")
    LocalDateTime fechaModificacion

    @OneToMany(mappedBy = "producto")
    Set<ProductosCarrito> carritos

    @OneToMany(mappedBy = "producto")
    Set<ProductosCompra> compras

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void antesDeUpdate(){
        this.fechaModificacion = LocalDateTime.now();
    }

}
