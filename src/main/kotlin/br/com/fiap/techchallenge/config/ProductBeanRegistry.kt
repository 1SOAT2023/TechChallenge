package br.com.fiap.techchallenge.config

import br.com.fiap.techchallenge.application.core.usecase.CreateProductUseCaseImpl
import br.com.fiap.techchallenge.application.core.usecase.FindProductBySkuUseCaseImpl
import br.com.fiap.techchallenge.application.core.usecase.FindProductsByProductTypeUseCaseImpl
import br.com.fiap.techchallenge.application.ports.`in`.ICreateProductUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IFindProductBySkuUseCase
import br.com.fiap.techchallenge.application.ports.`in`.IFindProductsByProductTypeUseCase
import br.com.fiap.techchallenge.application.ports.out.IProductPersistence
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProductBeanRegistry {

    @Bean
    fun createProductUseCase(productPersistence: IProductPersistence): ICreateProductUseCase{
        return CreateProductUseCaseImpl(productPersistence)
    }

    @Bean
    fun findBySku(productPersistence: IProductPersistence): IFindProductBySkuUseCase{
        return FindProductBySkuUseCaseImpl(productPersistence)
    }

    @Bean
    fun findByProductType(productPersistence: IProductPersistence): IFindProductsByProductTypeUseCase{
        return FindProductsByProductTypeUseCaseImpl(productPersistence)
    }

}