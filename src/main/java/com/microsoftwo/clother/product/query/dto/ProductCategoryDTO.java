package com.microsoftwo.clother.product.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductCategoryDTO {
    private int id; // 상품 번호
    private String brandName; // 브랜드명
    private String imageUrl; // 상품 이미지
    private CategoryDTO category; // 카테고리 정보
}
