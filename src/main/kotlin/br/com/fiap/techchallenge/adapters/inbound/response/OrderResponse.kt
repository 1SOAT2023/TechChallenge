package br.com.fiap.techchallenge.adapters.inbound.response

import br.com.fiap.techchallenge.application.core.domain.Order
import br.com.fiap.techchallenge.application.core.enums.OrderStatus
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class OrderResponse(
    var orderCode: String,
    val client: ClientResponse? = null,
    val products: List<ProductResponse>,
    val status: OrderStatus = OrderStatus.RECEIVED,
    val statusUpdatedAt: LocalDateTime? = null,
    val total: Double,
    val additionalNotes: String? = null,
    val paymentMethod: String,
    val orderDate: LocalDateTime? = null
)

fun Order.toOrderResponse() = OrderResponse(
    orderCode = orderCode!!,
    client = client?.toClientResponse(),
    products = products.map { it.toProductResponse() },
    status = status!!,
    statusUpdatedAt = statusUpdatedAt,
    total = total!!,
    additionalNotes = additionalNotes,
    paymentMethod = paymentMethod,
    orderDate = orderDate
)