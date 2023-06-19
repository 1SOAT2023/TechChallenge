package br.com.fiap.techchallenge.adapters.inbound.response

import br.com.fiap.techchallenge.application.core.domain.Client

data class ClientResponse(
    var id: Int = 0,
    var name: String = "",
    var cpf: String = "",
    var email: String = "",
    var phone: String = ""
)

fun Client.toClientResponse() = ClientResponse(
    id = id!!,
    name = name,
    cpf = cpf,
    email = email,
    phone = phone
)