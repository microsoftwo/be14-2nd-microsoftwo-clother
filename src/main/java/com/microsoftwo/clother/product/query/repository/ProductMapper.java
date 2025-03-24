package com.microsoftwo.clother.product.query.repository;

import com.microsoftwo.clother.product.query.dto.CategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductCategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductDetailDTO;
import com.microsoftwo.clother.product.query.dto.ProductRegistHistoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<CategoryDTO> selectAllCategories();

    List<ProductCategoryDTO> selectAllProductsByCategory(@Param("categoryNames") List<String> categoryNames);

    List<ProductRegistHistoryDTO> selectProductHistoryByUserId(int userId);

    List<ProductDetailDTO> selectProductDetailByProductId(int productId);


}
