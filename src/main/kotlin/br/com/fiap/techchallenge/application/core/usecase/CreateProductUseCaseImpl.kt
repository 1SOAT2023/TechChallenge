package br.com.fiap.techchallenge.application.core.usecase

import br.com.fiap.techchallenge.application.core.domain.Product
import br.com.fiap.techchallenge.application.core.exception.InvalidProductException
import br.com.fiap.techchallenge.application.ports.`in`.ICreateProductUseCase
import br.com.fiap.techchallenge.application.ports.out.IProductPersistence
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

class CreateProductUseCaseImpl(
    private val productPersistence: IProductPersistence
) : ICreateProductUseCase {
    override fun save(product: Product): Product {
        require(product.isValid()) {
            throw InvalidProductException("Product is invalid, it needs a title!")
        }

        return productPersistence.save(product)
    }

}