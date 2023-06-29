package br.com.fiap.techchallenge.adapters.outbound.service

import br.com.fiap.techchallenge.adapters.inbound.entity.toEntity
import br.com.fiap.techchallenge.adapters.outbound.repository.IOrderRepository
import br.com.fiap.techchallenge.application.core.domain.Order
import br.com.fiap.techchallenge.application.ports.out.IOrderPersistence
import org.springframework.stereotype.Service

@Service
class OrderPersistenceImpl(
    private val orderRepository: IOrderRepository
) : IOrderPersistence {

    override fun findAll(): List<Order> =
        orderRepository.findAll().map { it.toOrder() }

    override fun save(order: Order) =
        orderRepository.save(order.toEntity()).toOrder()

}