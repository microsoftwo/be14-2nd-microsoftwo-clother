package com.microsoftwo.clother.post.query.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDetailDTO {
    private int id; // tag 번호
    private int productId;
    private BigDecimal productTagPositionX;
    private BigDecimal productTagPositionY;
    private String brandName; // 브랜드명
    private String name; // 상품명
    private int price; // 가격
    private String link; // 제품 url
    private String imageUrl; // 상품 이미지
    private int categoryId; // 카테고리 번호
    private String categoryName; // 카테고리 이름
}
