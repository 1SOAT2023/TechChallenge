package br.com.fiap.techchallenge.application.ports.out

import br.com.fiap.techchallenge.application.BaseDatabaseIntegrationTest
import br.com.fiap.techchallenge.application.core.domain.Client
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ClientPersistenceIntegrationTest : BaseDatabaseIntegrationTest() {

    @Autowired
    lateinit var clientPersistence: IClientPersistence

    @Test
    fun `should save a client`() {
        val clientToSave = Client(1, "Luiz", "123123123", "luiz@email.com", "21 9999999")
        val savedClient = clientPersistence.save(clientToSave)

        assertEquals(clientToSave, savedClient)
    }

}