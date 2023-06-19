package br.com.fiap.techchallenge.config

import br.com.fiap.techchallenge.application.core.usecase.CreateClientUseCaseImpl
import br.com.fiap.techchallenge.application.ports.`in`.ICreateClientUseCase
import br.com.fiap.techchallenge.application.ports.out.IClientPersistence
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientBeanRegistry {

    @Bean
    fun createClientUseCase(clientPersistence: IClientPersistence): ICreateClientUseCase {
        return CreateClientUseCaseImpl(clientPersistence)
    }
}