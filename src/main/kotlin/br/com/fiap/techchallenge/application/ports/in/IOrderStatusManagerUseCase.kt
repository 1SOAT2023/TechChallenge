package br.com.fiap.techchallenge.application.ports.`in`

interface IOrderStatusManagerUseCase {

    fun updateToInPreparationStatus(orderCode: String)
    fun updateToReadyStatus(orderCode: String)
    fun updateToFinishedStatus(orderCode: String)

}