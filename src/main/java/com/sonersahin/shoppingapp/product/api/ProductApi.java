package com.sonersahin.shoppingapp.product.api;

import com.sonersahin.shoppingapp.product.model.product.ProductDetailResponse;
import com.sonersahin.shoppingapp.product.model.product.ProductResponse;
import com.sonersahin.shoppingapp.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductApi {
    private final ProductService productService;

    @GetMapping
    public Flux<ProductResponse> getAllProducts(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ProductDetailResponse> getProductDetail(@PathVariable("id")  String id){
        return productService.getProductDetail(id);
    }

}
