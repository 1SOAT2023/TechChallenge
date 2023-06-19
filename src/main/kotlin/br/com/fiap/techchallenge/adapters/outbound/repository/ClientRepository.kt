package br.com.fiap.techchallenge.adapters.outbound.repository

import br.com.fiap.techchallenge.adapters.inbound.entity.ClientEntity
import br.com.fiap.techchallenge.application.core.domain.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<ClientEntity, String>{
    fun findByCpf(cpf: String): ClientEntity?
}