package br.com.fiap.techchallenge.application.ports.`in`

interface IPaymentStatusManagerUseCase {
    fun updateToApproveStatus(paymentId: String)
    fun updateToRecusedStatus(paymentId: String)
}