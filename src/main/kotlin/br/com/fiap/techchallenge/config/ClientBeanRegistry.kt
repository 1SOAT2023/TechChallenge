package br.com.fiap.techchallenge.config

import br.com.fiap.techchallenge.application.core.usecase.CreateClientUseCaseImpl
import br.com.fiap.techchallenge.application.core.usecase.IdentifyClientByCPFUseCaseImpl
import br.com.fiap.techchallenge.application.ports.`in`.ICreateClientUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IIdentifyClientByCPFUseCase
import br.com.fiap.techchallenge.application.ports.out.IClientPersistence
import br.com.fiap.techchallenge.application.ports.out.IIdentifyClientPersistence
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientBeanRegistry {

    @Bean
    fun createClientUseCase(clientPersistence: IClientPersistence): ICreateClientUseCase {
        return CreateClientUseCaseImpl(clientPersistence)
    }

    @Bean
    fun identifyClientUseCase(iIdentifyClientPersistence: IIdentifyClientPersistence): IIdentifyClientByCPFUseCase {
        return IdentifyClientByCPFUseCaseImpl(iIdentifyClientPersistence)
    }

}