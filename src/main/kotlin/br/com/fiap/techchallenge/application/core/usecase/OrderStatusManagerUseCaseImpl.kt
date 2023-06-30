package br.com.fiap.techchallenge.application.core.usecase

import br.com.fiap.techchallenge.application.ports.`in`.IOrderStatusManagerUseCase
import br.com.fiap.techchallenge.application.ports.out.IOrderPersistence

class OrderStatusManagerUseCaseImpl(
    private val orderPersistence: IOrderPersistence
) : IOrderStatusManagerUseCase {

    override fun updateToInPreparationStatus(orderCode: String)  =
        orderPersistence.updateToInPreparationStatus(orderCode)


    override fun updateToReadyStatus(orderCode: String) =
        orderPersistence.updateToReadyStatus(orderCode)


    override fun updateToFinishedStatus(orderCode: String) =
        orderPersistence.updateToFinishedStatus(orderCode)

}