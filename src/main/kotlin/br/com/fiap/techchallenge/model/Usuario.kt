package br.com.fiap.techchallenge.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "usuarios")
data class Usuario(
    @Id
    val id: Long,
    val nome: String,
    val email: String
)