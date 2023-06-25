package br.com.fiap.techchallenge.application.core.usecase

import br.com.fiap.techchallenge.application.core.domain.Client
import br.com.fiap.techchallenge.application.core.exception.ClientNotFoundException
import br.com.fiap.techchallenge.application.ports.`in`.IIdentifyClientByCPFUseCase
import br.com.fiap.techchallenge.application.ports.out.IIdentifyClientPersistence

class IdentifyClientByCPFUseCaseImpl(
    private val persistence: IIdentifyClientPersistence
): IIdentifyClientByCPFUseCase {

    override fun identifyClientByCPF(cpf: String): Client {
        try {
            return persistence.findByCpf(cpf)!!
        } catch (e: NullPointerException) {
            throw ClientNotFoundException("Cliente não localizado")
        }

    }
}