package br.com.fiap.techchallenge.adapters.outbound.service

import br.com.fiap.techchallenge.adapters.inbound.entity.toEntity
import br.com.fiap.techchallenge.adapters.outbound.repository.IClientRepository
import br.com.fiap.techchallenge.application.core.domain.Client
import br.com.fiap.techchallenge.application.ports.out.IClientPersistence
import org.springframework.stereotype.Service

@Service
class ClientPersistenceImpl(
    private val clientRepository: IClientRepository
) : IClientPersistence{
    override fun save(client: Client): Client {
        return clientRepository.save(client.toEntity()).toClient()
    }
}