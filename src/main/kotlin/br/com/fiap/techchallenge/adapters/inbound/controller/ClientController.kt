package br.com.fiap.techchallenge.adapters.inbound.controller

import br.com.fiap.techchallenge.adapters.inbound.request.CreateClientRequest
import br.com.fiap.techchallenge.adapters.inbound.response.ClientResponse
import br.com.fiap.techchallenge.adapters.inbound.response.toClientResponse
import br.com.fiap.techchallenge.application.core.exception.ClientNotFoundException
import br.com.fiap.techchallenge.application.ports.`in`.ICreateClientUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IIdentifyClientByCPFUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ClientController(
    private val createClientUseCase: ICreateClientUseCase,
    private val identificarClientePorCPFUseCase: IIdentifyClientByCPFUseCase
) {

    @PostMapping("/v1/clients")
    fun create(@RequestBody request: CreateClientRequest): ResponseEntity<ClientResponse> {
        val client = createClientUseCase.save(request.toClient()).toClientResponse()
        return ResponseEntity.status(HttpStatus.CREATED).body(client)
    }

    @GetMapping("/v1/clients/{cpf}")
    fun identificarPorCPF(@PathVariable cpf:String):ResponseEntity<ClientResponse?> {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(identificarClientePorCPFUseCase.identifyClientByCPF(cpf).toClientResponse())
        } catch (e: ClientNotFoundException) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null)
        }
    }
}