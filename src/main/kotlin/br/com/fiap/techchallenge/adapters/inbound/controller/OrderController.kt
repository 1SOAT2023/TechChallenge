package br.com.fiap.techchallenge.adapters.inbound.controller

import br.com.fiap.techchallenge.adapters.inbound.request.CreateOrderRequest
import br.com.fiap.techchallenge.adapters.inbound.response.OrderResponse
import br.com.fiap.techchallenge.adapters.inbound.response.toOrderResponse
import br.com.fiap.techchallenge.application.ports.`in`.ICreateOrderUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IFindAllOrdersUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IFindClientByCodeUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IFindProductBySkuUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class OrderController(
    private val findAllOrdersUseCase: IFindAllOrdersUseCase,
    private val createOrdersUseCase: ICreateOrderUseCase,
    private val findClientByCodeUseCase: IFindClientByCodeUseCase,
    private val findProductBySkuUseCase: IFindProductBySkuUseCase,
) {

    @GetMapping("/v1/orders")
    fun findByProductType(): ResponseEntity<List<OrderResponse?>> =
        ResponseEntity
            .status(HttpStatus.OK)
            .body(
                findAllOrdersUseCase.findAll().map { it.toOrderResponse() }
            )

    @PostMapping("/v1/orders")
    fun create(@RequestBody request: CreateOrderRequest): ResponseEntity<OrderResponse> {
        val client = request.clientCode?.let { findClientByCodeUseCase.findByCode(it) }
        val products = request.productsSku.map { findProductBySkuUseCase.findBySku(it) }

        val order = createOrdersUseCase.save(request.toOrder(client = client, products = products)).toOrderResponse()
        return ResponseEntity.status(HttpStatus.CREATED).body(order)
    }
}