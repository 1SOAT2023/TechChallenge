package br.com.fiap.techchallenge.adapters.inbound.controller

import br.com.fiap.techchallenge.adapters.inbound.request.CreatePaymentRequest
import br.com.fiap.techchallenge.adapters.inbound.request.CreatePaymentResponse
import br.com.fiap.techchallenge.adapters.inbound.response.toPaymentResponse
import br.com.fiap.techchallenge.application.ports.`in`.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PaymentController(
    private val findOrderByCodeUseCase: IFindOrderByCodeUseCase,
    private val createPaymentUseCase: ICreatePaymentUseCase
) {
    @PostMapping("/v1/payment")
    fun create(@RequestBody request: CreatePaymentRequest): ResponseEntity<CreatePaymentResponse> {
        val order = request.orderId?.let { findOrderByCodeUseCase.findByOrderId(it) }

        val payment = createPaymentUseCase.save(request.toPayment(order!!)).toPaymentResponse()
        return ResponseEntity.status(HttpStatus.CREATED).body(CreatePaymentResponse(payment.paymentId))
    }

}