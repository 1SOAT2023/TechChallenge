package br.com.fiap.techchallenge.controller

import br.com.fiap.techchallenge.model.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/usuarios"], produces = ["application/json"], name = "Usuarios")
class UsuarioController {
    @GetMapping
    fun listAll():List<Usuario> {
        return emptyList<Usuario>()
    }
}