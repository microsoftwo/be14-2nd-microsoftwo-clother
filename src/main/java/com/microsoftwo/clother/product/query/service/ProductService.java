package com.microsoftwo.clother.product.query.service;

import com.microsoftwo.clother.product.query.dto.CategoryDTO;
import com.microsoftwo.clother.product.query.dto.CategoryProductDTO;
import com.microsoftwo.clother.product.query.dto.ProductDetailDTO;
import com.microsoftwo.clother.product.query.dto.ProductRegistHistoryDTO;

import java.util.List;

public interface ProductService {

    List<CategoryDTO> getSubCategories(String categoryId);

    CategoryProductDTO getProductListByCategory(String categoryName);

    List<ProductRegistHistoryDTO> getProductRegistHistoryByUserId(int userId);

    ProductDetailDTO getProductDetailByProductId(int productId);
}
