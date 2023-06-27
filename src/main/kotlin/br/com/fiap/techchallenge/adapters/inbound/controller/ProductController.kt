package br.com.fiap.techchallenge.adapters.inbound.controller

import br.com.fiap.techchallenge.adapters.inbound.request.CreateProductRequest
import br.com.fiap.techchallenge.adapters.inbound.response.ProductResponse
import br.com.fiap.techchallenge.adapters.inbound.response.toProductResponse
import br.com.fiap.techchallenge.application.core.enums.ProductType
import br.com.fiap.techchallenge.application.ports.`in`.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ProductController(
    private val createProductUseCase: ICreateProductUseCase,
    private val findProductBySkuUseCase: IFindProductBySkuUseCase,
    private val findByProductTypeUseCase: IFindProductsByProductTypeUseCase
) {
    @PostMapping("/v1/products")
    fun create(@RequestBody request: CreateProductRequest): ResponseEntity<ProductResponse> {
        val product = createProductUseCase.save(request.toProduct()).toProductResponse()
        return ResponseEntity.status(HttpStatus.CREATED).body(product)
    }

    @GetMapping("/v1/products/{sku}")
    fun findfyBySKU(@PathVariable sku:String):ResponseEntity<ProductResponse?> =
        ResponseEntity
            .status(HttpStatus.OK)
            .body(findProductBySkuUseCase.findBySku(sku).toProductResponse())

    @GetMapping("/v1/products/product-type/{productType}")
    fun findByProductType(@PathVariable productType:String):ResponseEntity<List<ProductResponse?>> =
        ResponseEntity
            .status(HttpStatus.OK)
            .body(
                findByProductTypeUseCase.findAllProductTypes(
                    ProductType.valueOf(productType)
                ).map{ it.toProductResponse() }
            )
    }


