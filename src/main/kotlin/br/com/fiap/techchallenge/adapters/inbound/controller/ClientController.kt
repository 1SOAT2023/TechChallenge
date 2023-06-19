package br.com.fiap.techchallenge.adapters.inbound.controller

import br.com.fiap.techchallenge.adapters.inbound.request.CreateClientRequest
import br.com.fiap.techchallenge.adapters.inbound.response.ClientResponse
import br.com.fiap.techchallenge.adapters.inbound.response.toClientResponse
import br.com.fiap.techchallenge.application.ports.`in`.ICreateClientUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ClientController(
    private val createClientUseCase: ICreateClientUseCase
) {

    @PostMapping("/v1/clients")
    fun create(@RequestBody request: CreateClientRequest): ResponseEntity<ClientResponse> {
        val client = createClientUseCase.save(request.toClient()).toClientResponse()
        return ResponseEntity.status(HttpStatus.CREATED).body(client)
    }
}