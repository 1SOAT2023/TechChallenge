package br.com.fiap.techchallenge.config

import br.com.fiap.techchallenge.application.core.usecase.ActivationClientUseCaseImpl
import br.com.fiap.techchallenge.application.core.usecase.CreateClientUseCaseImpl
import br.com.fiap.techchallenge.application.core.usecase.FindAllClientsUseCaseImpl
import br.com.fiap.techchallenge.application.core.usecase.FindClientByCodeUseCaseImpl
import br.com.fiap.techchallenge.application.ports.`in`.IActivationClientUseCase
import br.com.fiap.techchallenge.application.core.usecase.IdentifyClientByCPFUseCaseImpl
import br.com.fiap.techchallenge.application.ports.`in`.ICreateClientUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IFindAllClientsUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IFindClientByCodeUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IIdentifyClientByCPFUseCase
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
    fun findClientByCodeUseCase(clientPersistence: IClientPersistence): IFindClientByCodeUseCase {
        return FindClientByCodeUseCaseImpl(clientPersistence)
    }

    @Bean
    fun findAllClientsUseCase(clientPersistence: IClientPersistence): IFindAllClientsUseCase {
        return FindAllClientsUseCaseImpl(clientPersistence)
    }

    @Bean
    fun activeClientUseCase(clientPersistence: IClientPersistence): IActivationClientUseCase {
        return ActivationClientUseCaseImpl(clientPersistence)
    }

    @Bean
    fun identifyClientUseCase(clientPersistence: IClientPersistence): IIdentifyClientByCPFUseCase {
        return IdentifyClientByCPFUseCaseImpl(clientPersistence)
    }

}