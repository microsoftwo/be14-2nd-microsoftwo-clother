package com.microsoftwo.clother.product.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ProductDetailDTO {
    private int id; // 상품 번호
    private String brandName; // 브랜드명
    private String name; // 상품명
    private int price; // 가격
    private String link; // 제품 url
    private String imageUrl; // 상품 이미지
}
