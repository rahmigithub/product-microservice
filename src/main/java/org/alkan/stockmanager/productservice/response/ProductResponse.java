package org.alkan.stockmanager.productservice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductResponse {

    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;
    /* Response içinde setleme aşamasında getTime methodu kullanılacak.
     O Yüzden Long tanımlandı */
    private Long productCreatedDate;
    private Long productUpdatedDate;


}
