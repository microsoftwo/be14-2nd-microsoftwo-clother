package com.microsoftwo.clother.product.query.service;

import com.microsoftwo.clother.product.query.dto.CategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductCategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductDetailDTO;
import com.microsoftwo.clother.product.query.dto.ProductRegistHistoryDTO;
import com.microsoftwo.clother.product.query.repository.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    /*  User 도메인과 연결  */

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<CategoryDTO> getCategories() {
        List<CategoryDTO> categoryDTOList = productMapper.selectAllCategories();
        return categoryDTOList;
    }

    @Override
    public List<ProductCategoryDTO> getProductListByCategory(List<String> categoryNames) {
        List<ProductCategoryDTO> productCategoryDTOList = productMapper.selectAllProductsByCategory(categoryNames);
        return productCategoryDTOList;
    }

    @Override
    public List<ProductRegistHistoryDTO> getProductRegistHistoryByUserId(int userId) {
        List<ProductRegistHistoryDTO> productRegistHistoryDTOList = productMapper.selectProductHistoryByUserId(userId);
        return productRegistHistoryDTOList;
    }

    @Override
    public List<ProductDetailDTO> getProductDetailByProductId(int productId) {
        List<ProductDetailDTO> productDetailDTOList = productMapper.selectProductDetailByProductId(productId);
        return productDetailDTOList;
    }
}
