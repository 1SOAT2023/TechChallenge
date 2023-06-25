package br.com.fiap.techchallenge.adapters.outbound.service

import br.com.fiap.techchallenge.adapters.inbound.entity.toEntity
import br.com.fiap.techchallenge.adapters.outbound.repository.ClientRepository
import br.com.fiap.techchallenge.application.core.domain.Client
import br.com.fiap.techchallenge.application.ports.out.IClientPersistence
import br.com.fiap.techchallenge.application.ports.out.IIdentifyClientPersistence
import org.springframework.stereotype.Service

@Service
class IdentifyClientByCpfPersistenceImpl(
    private val clientRepository: ClientRepository
) : IIdentifyClientPersistence{
    override fun findByCpf(cpf: String): Client? {
        return clientRepository.findByCpf(cpf)?.toClient()
    }

}