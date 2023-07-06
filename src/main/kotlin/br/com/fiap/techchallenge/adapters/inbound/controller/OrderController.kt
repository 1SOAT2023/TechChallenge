package br.com.fiap.techchallenge.adapters.inbound.controller

import br.com.fiap.techchallenge.adapters.inbound.request.CreateOrderRequest
import br.com.fiap.techchallenge.adapters.inbound.response.OrderResponse
import br.com.fiap.techchallenge.adapters.inbound.response.toOrderResponse
import br.com.fiap.techchallenge.application.core.enums.OrderStatus
import br.com.fiap.techchallenge.application.ports.`in`.*
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
    private val orderStatusManagerUseCase: IOrderStatusManagerUseCase,
    private val findOrderByCodeUseCase: IFindOrderByCodeUseCase
) {

    @GetMapping("/v1/orders")
    fun findAllOrders(): ResponseEntity<List<OrderResponse?>> =
        ResponseEntity
            .status(HttpStatus.OK)
            .body(
                findAllOrdersUseCase.findAll().map { it.toOrderResponse() }
            )

    @GetMapping("/v1/orders/checkout")
    fun checkout(): ResponseEntity<List<OrderResponse?>> {
        val orders = findAllOrdersUseCase.findAll().filter { it.status != OrderStatus.FINISHED }
        val orderResponses = orders.map { it.toOrderResponse() }
        return ResponseEntity.status(HttpStatus.OK).body(orderResponses)
    }

    @PostMapping("/v1/orders")
    fun create(@RequestBody request: CreateOrderRequest): ResponseEntity<OrderResponse> {
        val client = request.clientCode?.let { findClientByCodeUseCase.findByCode(it) }
        val products = request.productsSku.map { findProductBySkuUseCase.findBySku(it) }

        val order = createOrdersUseCase.save(request.toOrder(client = client, products = products)).toOrderResponse()
        return ResponseEntity.status(HttpStatus.CREATED).body(order)
    }

    @PutMapping("/v1/orders/{orderCode}/in-preparation")
    fun updateToInPreparationStatus(@PathVariable orderCode: String): ResponseEntity<Unit> {
        orderStatusManagerUseCase.updateToInPreparationStatus(orderCode)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @PutMapping("/v1/orders/{orderCode}/ready")
    fun updateToReadyStatus(@PathVariable orderCode: String): ResponseEntity<Unit> {
        orderStatusManagerUseCase.updateToReadyStatus(orderCode)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @PutMapping("/v1/orders/{orderCode}/finished")
    fun updateToCompletedStatus(@PathVariable orderCode: String): ResponseEntity<Unit> {
        orderStatusManagerUseCase.updateToFinishedStatus(orderCode)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @GetMapping("/v1/orders/{orderCode}")
    fun findByCode(@PathVariable orderCode: String): ResponseEntity<OrderResponse> {
        val order = findOrderByCodeUseCase.findByCode(orderCode).toOrderResponse()
        return ResponseEntity.ok(order)
    }

}