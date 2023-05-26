package com.sonersahin.shoppingapp.product.service;

import com.sonersahin.shoppingapp.product.domain.Product;
import com.sonersahin.shoppingapp.product.domain.ProductImage;
import com.sonersahin.shoppingapp.product.domain.category.Category;
import com.sonersahin.shoppingapp.product.domain.es.CategoryEs;
import com.sonersahin.shoppingapp.product.domain.es.CompanyEs;
import com.sonersahin.shoppingapp.product.domain.es.ProductEs;
import com.sonersahin.shoppingapp.product.repository.es.ProductEsRepository;
import com.sonersahin.shoppingapp.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductEsService {

    private final ProductEsRepository productEsRepository;
    private final CategoryService categoryService;

    public Mono<ProductEs> saveNewProduct(Product product){
        return productEsRepository.save(
            ProductEs.builder()
                    .active(product.getActive())
                    .code(product.getCode())
                    .description(product.getDescription())
                    .features(product.getFeatures())
                    .id(product.getId())
                    .price(product.getPrice())
                    .name(product.getName())
                    //TODO get company name and code
                    .seller(CompanyEs.builder().id(product.getCompanyId()).name("Test").build())
                    .category(getProductCategory(product.getCategoryId()))
                    .images(product.getProductImage().stream()
                            .map(ProductImage::getUrl)
                            .collect(Collectors.toList()))
                    .build());
    }

    private CategoryEs getProductCategory(String categoryId) {
        Category category = categoryService.getById(categoryId);
        return CategoryEs.builder().name(category.getName()).id(category.getId()).code(category.getCode()).build();
    }

    public Flux<ProductEs> findAll() {
        return productEsRepository.findAll();
    }

    public Mono<ProductEs> findById(String id) {
        return productEsRepository.findById(id);
    }
}
