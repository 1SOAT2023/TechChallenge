package br.com.fiap.techchallenge.adapters.inbound.entity

import br.com.fiap.techchallenge.application.core.domain.Product
import br.com.fiap.techchallenge.application.core.enums.ProductType
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.OffsetDateTime
import java.util.*

@Entity(name = "products")
data class ProductEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    var sku: String? = null,
    val title: String,
    val urlName: String,
    val productType: String,
    private var isActive: Boolean = true,

    @CreationTimestamp
    val creationDate: OffsetDateTime? = null
) {
    @PrePersist
    fun generateCode() {
        sku = UUID.randomUUID().toString()
    }

    fun toProduct(): Product {
        return Product(id!!, sku!!, title, urlName, ProductType.valueOf(productType), isActive)
    }

    fun activate() {
        isActive = true
    }

    fun desactivate() {
        isActive = false
    }
}

fun Product.toEntity(): ProductEntity {
    return ProductEntity(sku = sku, isActive = isActive!!, productType = productType.toString(), title = title, urlName = urlName)
}


