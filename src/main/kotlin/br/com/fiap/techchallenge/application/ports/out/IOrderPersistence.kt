package br.com.fiap.techchallenge.application.ports.out

import br.com.fiap.techchallenge.application.core.domain.Order

interface IOrderPersistence {
    fun findAll(): List<Order>
    fun findByCode(orderCode: String): Order?
    fun save(order: Order): Order
    fun updateToInPreparationStatus(orderCode: String)
    fun updateToReadyStatus(orderCode: String)
    fun updateToFinishedStatus(orderCode: String)
}