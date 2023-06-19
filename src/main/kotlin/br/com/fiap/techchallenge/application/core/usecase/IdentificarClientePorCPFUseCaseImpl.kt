package br.com.fiap.techchallenge.application.core.usecase

import br.com.fiap.techchallenge.adapters.inbound.response.ClientResponse
import br.com.fiap.techchallenge.adapters.inbound.response.toClientResponse
import br.com.fiap.techchallenge.adapters.outbound.repository.ClientRepository
import br.com.fiap.techchallenge.application.core.exception.ClientNotFoundException
import br.com.fiap.techchallenge.application.ports.`in`.IIdentificarClientePorCPFUseCase

class IdentificarClientePorCPFUseCaseImpl(
    private val repository: ClientRepository
): IIdentificarClientePorCPFUseCase {

    override fun identificarClientePorCPF(cpf: String):ClientResponse {
        try {
            return repository.findByCpf(cpf)!!.toClient().toClientResponse()
        } catch (e: NullPointerException) {
            throw ClientNotFoundException("Cliente não localizado")
        }

    }
}