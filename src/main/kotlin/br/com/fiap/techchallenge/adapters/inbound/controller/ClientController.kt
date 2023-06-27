package br.com.fiap.techchallenge.adapters.inbound.controller

import br.com.fiap.techchallenge.adapters.inbound.request.CreateClientRequest
import br.com.fiap.techchallenge.adapters.inbound.response.ClientResponse
import br.com.fiap.techchallenge.adapters.inbound.response.toClientResponse
import br.com.fiap.techchallenge.application.core.exception.ClientNotFoundException
import br.com.fiap.techchallenge.application.ports.`in`.IActivationClientUseCase
import br.com.fiap.techchallenge.application.ports.`in`.ICreateClientUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IIdentifyClientByCPFUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IFindAllClientsUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IFindClientByCodeUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ClientController(
    private val identifyClientByCPFUseCase: IIdentifyClientByCPFUseCase,
    private val createClientUseCase: ICreateClientUseCase,
    private val findClientByCodeUseCase: IFindClientByCodeUseCase,
    private val findAllClientsUseCase: IFindAllClientsUseCase,
    private val activeClientUseCase: IActivationClientUseCase
) {

    @PostMapping("/v1/clients")
    fun create(@RequestBody request: CreateClientRequest): ResponseEntity<ClientResponse> {
        val client = createClientUseCase.save(request.toClient()).toClientResponse()
        return ResponseEntity.status(HttpStatus.CREATED).body(client)
    }

    @GetMapping("/v1/clients/{cpf}")
    fun identifyByCPF(@PathVariable cpf:String):ResponseEntity<ClientResponse?> {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(identifyClientByCPFUseCase.identifyClientByCPF(cpf).toClientResponse())
        } catch (e: ClientNotFoundException) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null)
        }
    }

    @GetMapping("/v1/clients/code/{code}")
    fun findByCode(
        @PathVariable code: String
    ): ResponseEntity<ClientResponse> {
        val client = findClientByCodeUseCase.findByCode(code).toClientResponse()
        return ResponseEntity.ok(client)
    }

    @GetMapping("/v1/clients")
    fun findAll(): ResponseEntity<List<ClientResponse>> {
        val clients = findAllClientsUseCase.findAll().map { it.toClientResponse() }
        return ResponseEntity.ok(clients)
    }

    @PutMapping("/v1/clients/{code}/activate")
    fun activate(@PathVariable code: String): ResponseEntity<Unit> {
        activeClientUseCase.activate(code)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/v1/clients/{code}/deactivate")
    fun deactivate(@PathVariable code: String): ResponseEntity<Unit> {
        activeClientUseCase.deactivate(code)
        return ResponseEntity.ok().build()
    }

}