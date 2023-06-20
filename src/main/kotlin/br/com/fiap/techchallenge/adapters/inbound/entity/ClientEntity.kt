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
    val id: Int? = null,
    var code: String? = null,
    val name: String,
    val cpf: String,
    val email: String,
    val phone: String,
    val active: Boolean = true,

    @CreationTimestamp
    val creationDate: OffsetDateTime? = null
) {
    @PrePersist
    fun generateCode() {
        code = UUID.randomUUID().toString()
    }

    fun toClient(): Client {
        return Client(id!!, code!!, name, cpf, email, phone, active)
    }
}

fun Client.toEntity(): ClientEntity {
    return ClientEntity(code = code, name = name, cpf = cpf, email = email, phone = phone, active = active!!)
}


