package br.com.fiap.techchallenge.application.core.usecase

import br.com.fiap.techchallenge.application.core.domain.Order
import br.com.fiap.techchallenge.application.core.exception.InvalidOrderException
import br.com.fiap.techchallenge.application.ports.`in`.ICreateOrderUseCase
import br.com.fiap.techchallenge.application.ports.out.IOrderPersistence

class CreateOrderUseCaseImpl(
    private val orderPersistence: IOrderPersistence
) : ICreateOrderUseCase {

    override fun save(order: Order): Order {
        require(order.isValid()) {
            throw InvalidOrderException("Order is invalid, it needs at least one product!")
        }

        return orderPersistence.save(order)
    }
}