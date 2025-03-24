package com.microsoftwo.clother.product.query.repository;

import com.microsoftwo.clother.product.query.dto.CategoryDTO;
import com.microsoftwo.clother.product.query.dto.CategoryProductDTO;
import com.microsoftwo.clother.product.query.dto.ProductDetailDTO;
import com.microsoftwo.clother.product.query.dto.ProductRegistHistoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<CategoryDTO> selectSubCategories(String categoryName);

    CategoryProductDTO selectAllProductsByCategory(String categoryName);

    List<ProductRegistHistoryDTO> selectProductHistoryByUserId(int userId);

    ProductDetailDTO selectProductDetailByProductId(int productId);


}
