package com.sonersahin.shoppingapp.product.repository.mongo;

import com.sonersahin.shoppingapp.product.domain.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
