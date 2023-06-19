package br.com.fiap.techchallenge.adapters.inbound.request

import br.com.fiap.techchallenge.application.core.domain.Client

data class CreateClientRequest(
    var name: String,
    var cpf: String,
    var email: String,
    var phone: String) {

    fun toClient() = Client(name = name, cpf = cpf, email = email, phone = phone)
}