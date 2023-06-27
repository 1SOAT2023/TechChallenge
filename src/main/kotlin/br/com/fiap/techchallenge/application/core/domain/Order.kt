package br.com.fiap.techchallenge.application.core.domain

import br.com.fiap.techchallenge.application.core.enums.OrderStatus
import java.time.LocalDateTime

data class Order(
    val id: Int? = null,
    val orderCode: String,
    val client: Client,
    val products: List<Product>,
    val status: OrderStatus,
    val statusUpdatedAt: LocalDateTime,
    val total: Double,
    val additionalNotes: String? = null,
    val paymentMethod: String,
    val orderDate: LocalDateTime
) {
    fun isValid(): Boolean {
        return products.isNotEmpty()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Order

        if (id != other.id) return false
        if (orderCode != other.orderCode) return false
        if (client != other.client) return false
        if (products != other.products) return false
        if (status != other.status) return false
        if (statusUpdatedAt != other.statusUpdatedAt) return false
        if (total != other.total) return false
        if (additionalNotes != other.additionalNotes) return false
        if (paymentMethod != other.paymentMethod) return false
        return orderDate == other.orderDate
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + orderCode.hashCode()
        result = 31 * result + client.hashCode()
        result = 31 * result + products.hashCode()
        result = 31 * result + status.hashCode()
        result = 31 * result + statusUpdatedAt.hashCode()
        result = 31 * result + total.hashCode()
        result = 31 * result + (additionalNotes?.hashCode() ?: 0)
        result = 31 * result + paymentMethod.hashCode()
        result = 31 * result + orderDate.hashCode()
        return result
    }

    override fun toString(): String {
        return "Order(id=$id, orderCode='$orderCode', client=$client, products=$products, status=$status, statusUpdatedAt=$statusUpdatedAt, total=$total, additionalNotes=$additionalNotes, paymentMethod='$paymentMethod', orderDate=$orderDate)"
    }

}