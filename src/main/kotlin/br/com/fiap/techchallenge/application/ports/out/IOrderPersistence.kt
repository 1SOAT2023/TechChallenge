package br.com.fiap.techchallenge.application.ports.out

import br.com.fiap.techchallenge.application.core.domain.Order

interface IOrderPersistence {
    fun findAll(): List<Order>
    fun save(order: Order): Order
}