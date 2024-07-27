package org.alkan.stockmanager.productservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.alkan.stockmanager.productservice.enums.Language;
import org.alkan.stockmanager.productservice.exception.enums.FriendlyMessageCodes;
import org.alkan.stockmanager.productservice.exception.utils.FriendlyMessageUtils;
import org.alkan.stockmanager.productservice.repository.entity.Product;
import org.alkan.stockmanager.productservice.request.ProductCreateRequest;
import org.alkan.stockmanager.productservice.response.FriendlyMessage;
import org.alkan.stockmanager.productservice.response.InternalApiResponse;
import org.alkan.stockmanager.productservice.response.ProductResponse;
import org.alkan.stockmanager.productservice.service.IProductRepositoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/1.0/product")
@RequiredArgsConstructor
public class ProductController {

    /*
     private final ProductRepositoryServiceImpl productRepository;  'da çağırılabilinir diye düşünüyorum
      */
    private final IProductRepositoryService productRepositoryService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{language}/create")
    public InternalApiResponse<ProductResponse> createProduct(@PathVariable("language") Language language,
                                                              @RequestBody ProductCreateRequest productCreateRequest) {
        log.debug("[{}][createProduct] -> request: {}", this.getClass().getSimpleName(), productCreateRequest);
        Product product = productRepositoryService.createProduct(language, productCreateRequest);
        ProductResponse productResponse = convertProductResponse(product);
        log.debug("[{}][createProduct] -> response: {}", this.getClass().getSimpleName(), productResponse);
        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCodes.SUCCESS))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCodes.PRODUCT_SUCCESSFULLY_CREATED))
                        .build())
                .httpStatus(HttpStatus.CREATED)
                .hasError(false)
                .payload(productResponse)
                .build();

    }

    private ProductResponse convertProductResponse(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .productCreatedDate(product.getProductCreatedDate().getTime())
                .productUpdatedDate(product.getProductUpdatedDate().getTime())
                .build();
    }
}
