package br.com.fiap.techchallenge.application.ports.`in`

import br.com.fiap.techchallenge.adapters.inbound.response.ClientResponse

interface IIdentificarClientePorCPFUseCase {
    fun identificarClientePorCPF(cpf: String):ClientResponse
}