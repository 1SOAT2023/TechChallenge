package br.com.fiap.techchallenge.adapters.outbound.service

import br.com.fiap.techchallenge.adapters.inbound.entity.toEntity
import br.com.fiap.techchallenge.adapters.outbound.repository.IOrderRepository
import br.com.fiap.techchallenge.adapters.outbound.repository.IPaymentRepository
import br.com.fiap.techchallenge.application.core.domain.Order
import br.com.fiap.techchallenge.application.core.domain.Payment
import br.com.fiap.techchallenge.application.ports.out.IOrderPersistence
import br.com.fiap.techchallenge.application.ports.out.IPaymentPersistence
import org.springframework.stereotype.Service

@Service
class PaymentPersistenceImpl(
    private val paymentRepository: IPaymentRepository
) : IPaymentPersistence {

    override fun findByPaymentId(paymentId: String): Payment? =
        paymentRepository.findByPaymentId(paymentId)?.toPayment()

    override fun findAll(): List<Payment> {
        TODO("Not yet implemented")
    }

    override fun save(payment: Payment): Payment =
        paymentRepository.save(payment.toEntity()).toPayment()


    override fun updateToApproveStatus(paymentId: String) {
        TODO("Not yet implemented")
    }

    override fun updateToRecusedStatus(paymentId: String) {
        TODO("Not yet implemented")
    }

}