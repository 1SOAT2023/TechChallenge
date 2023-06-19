package br.com.fiap.techchallenge.adapters.inbound.entity

import br.com.fiap.techchallenge.application.core.domain.Client
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.OffsetDateTime
import java.util.*

@Entity(name = "clients")
data class ClientEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var name: String,
    var cpf: String,
    var email: String,
    var phone: String,

    var code: String? = null,

    @CreationTimestamp
    var creationDate: OffsetDateTime? = null
) {
    @PrePersist
    fun generateCode() {
        code = UUID.randomUUID().toString()
    }

    fun toClient(): Client {
        return Client(id!!, name, cpf, email, phone)
    }
}

fun Client.toEntity(): ClientEntity {
    return ClientEntity(name = name, cpf = cpf, email = email, phone = phone)
}


