package br.com.fiap.techchallenge.application.core.usecase

import br.com.fiap.techchallenge.application.ports.`in`.IPaymentStatusManagerUseCase
import br.com.fiap.techchallenge.application.ports.out.IPaymentPersistence

class PaymentStatusManagerUseCaseImpl(
    private val paymentPersistence: IPaymentPersistence
) : IPaymentStatusManagerUseCase {
    override fun updateToApproveStatus(paymentId: String) =
        paymentPersistence.updateToApproveStatus(paymentId)

    override fun updateToRecusedStatus(paymentId: String) =
        paymentPersistence.updateToRecusedStatus(paymentId)
}