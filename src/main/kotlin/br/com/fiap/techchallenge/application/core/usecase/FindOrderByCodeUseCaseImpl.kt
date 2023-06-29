package br.com.fiap.techchallenge.application.core.usecase

import br.com.fiap.techchallenge.application.core.exception.OrderNotFoundException
import br.com.fiap.techchallenge.application.ports.`in`.IFindOrderByCodeUseCase
import br.com.fiap.techchallenge.application.ports.out.IOrderPersistence

class FindOrderByCodeUseCaseImpl(
    private val orderPersistence: IOrderPersistence
) : IFindOrderByCodeUseCase {

    override fun findByCode(orderCode: String) =
        orderPersistence.findByCode(orderCode) ?:
            throw OrderNotFoundException("Order with code: $orderCode not found")
}