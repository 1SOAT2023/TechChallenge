package br.com.fiap.techchallenge.adapters.outbound.repository

import br.com.fiap.techchallenge.adapters.inbound.entity.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IClientRepository : JpaRepository<ClientEntity, String>