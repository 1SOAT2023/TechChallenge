package br.com.fiap.techchallenge.config

import br.com.fiap.techchallenge.adapters.outbound.repository.ClientRepository
import br.com.fiap.techchallenge.application.core.usecase.CreateClientUseCaseImpl
import br.com.fiap.techchallenge.application.core.usecase.IdentificarClientePorCPFUseCaseImpl
import br.com.fiap.techchallenge.application.ports.`in`.ICreateClientUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IIdentificarClientePorCPFUseCase
import br.com.fiap.techchallenge.application.ports.out.IClientPersistence
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientBeanRegistry {

    @Bean
    fun createClientUseCase(clientPersistence: IClientPersistence): ICreateClientUseCase {
        return CreateClientUseCaseImpl(clientPersistence)
    }

    @Bean
    fun identificarClienteUseCase(clientRepository: ClientRepository): IIdentificarClientePorCPFUseCase {
        return IdentificarClientePorCPFUseCaseImpl(clientRepository)
    }

}