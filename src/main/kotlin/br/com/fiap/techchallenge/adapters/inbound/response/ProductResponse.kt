package br.com.fiap.techchallenge.adapters.inbound.response

import br.com.fiap.techchallenge.application.core.domain.Client
import br.com.fiap.techchallenge.application.core.domain.Product

data class ProductResponse(
    val title: String = "",
    val sku: String,
    val productType: String = "",
    val isActive: Boolean = true
)

fun Product.toProductResponse() = ProductResponse(
    title = title,
    sku = sku,
    productType = productType.toString(),
    isActive = isActive!!
)