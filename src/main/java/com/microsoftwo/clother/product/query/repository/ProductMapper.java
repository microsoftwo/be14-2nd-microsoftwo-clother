package com.microsoftwo.clother.product.query.repository;

import com.microsoftwo.clother.product.query.dto.CategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductRegistHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    // 카테고리 목록 조회
    List<CategoryDTO> selectAllCategories();

    // 사용자가 등록 신청한 상품 목록 조회
    List<ProductRegistHistoryDTO> selectProductHistoryByUserId(int userId);
}
