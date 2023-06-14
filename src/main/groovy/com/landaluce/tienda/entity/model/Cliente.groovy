package com.landaluce.tienda.entity.model

import com.landaluce.tienda.service.repository.CarritoRepository
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import jakarta.persistence.Table
import org.springframework.beans.factory.annotation.Autowired

import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "clientes")
class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @Column(nullable = false, unique = true)
    String email

    @Column(nullable = false, length = 50)
    String nombre

    @Column(length = 50)
    String apellidos

    @Column(nullable = false, unique = true, length = 9)
    String telefono

    LocalDate nacimiento

    @Column(name = "fecha_alta")
    LocalDateTime fechaAlta

    @Column(name = "fecha_modificacion")
    LocalDateTime fechaModificacion

    @OneToOne(mappedBy = "cliente")
    Carrito carrito

    @OneToMany(mappedBy = "cliente")
    Set<Direccion> direcciones

    @OneToMany(mappedBy = "cliente")
    Set<Tarjeta> tarjetas

    @OneToMany(mappedBy = "cliente")
    Set<Compra> compras

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void antesDeUpdate(){
        this.fechaModificacion = LocalDateTime.now();
    }

}
