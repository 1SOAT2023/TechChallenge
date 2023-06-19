package br.com.fiap.techchallenge.application.ports.out

import br.com.fiap.techchallenge.application.core.domain.Client

fun interface IClientPersistence {
    fun save (client: Client): Client
}