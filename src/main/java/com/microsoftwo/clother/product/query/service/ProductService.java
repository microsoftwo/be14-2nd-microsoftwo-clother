package com.microsoftwo.clother.product.query.service;

import com.microsoftwo.clother.product.query.dto.CategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductCategoryDTO;
import java.util.List;

public interface ProductService {
    // 카테고리 목록 조회
    List<CategoryDTO> getCategories();

    // 카테고리 별 전체 상품 목록 조회
    List<ProductCategoryDTO> getProductListByCategory();

    // 사용자가 등록 신청한 상품 목록 조회
    List<ProductCategoryDTO> getProductListByUserId(int userId);

}
