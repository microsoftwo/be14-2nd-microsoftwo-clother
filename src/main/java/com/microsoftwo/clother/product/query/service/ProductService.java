package com.microsoftwo.clother.product.query.service;

import com.microsoftwo.clother.product.query.dto.CategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductCategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductDetailDTO;
import com.microsoftwo.clother.product.query.dto.ProductRegistHistoryDTO;

import java.util.List;

public interface ProductService {

    List<CategoryDTO> getCategories();

    List<ProductCategoryDTO> getProductListByCategory(List<String> categoryNames);

    List<ProductRegistHistoryDTO> getProductRegistHistoryByUserId(int userId);

    List<ProductDetailDTO> getProductDetailByProductId(int productId);
}
