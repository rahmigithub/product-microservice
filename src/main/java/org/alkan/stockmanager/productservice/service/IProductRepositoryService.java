package org.alkan.stockmanager.productservice.service;

import org.alkan.stockmanager.productservice.enums.Language;
import org.alkan.stockmanager.productservice.repository.entity.Product;
import org.alkan.stockmanager.productservice.request.ProductCreateRequest;
import org.alkan.stockmanager.productservice.request.ProductUpdateRequest;

import java.util.List;

public interface IProductRepositoryService {

    Product createProduct(Language language, ProductCreateRequest productCreateRequest);

    Product getProduct(Language language,Long productId);

    List<Product> getProducts(Language language);

    Product updateProduct(Language language, Long productId, ProductUpdateRequest productUpdateRequest);

    Product deleteProduct(Language language, Long productId);
}
