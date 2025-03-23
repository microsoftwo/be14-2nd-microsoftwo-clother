package com.microsoftwo.clother.product.query.service;

import com.microsoftwo.clother.product.query.dto.CategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductCategoryDTO;
import com.microsoftwo.clother.product.query.repository.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

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
    public List<ProductCategoryDTO> getProductListByCategory() {
        return List.of();
    }

    @Override
    public List<ProductCategoryDTO> getProductListByUserId(int userId) {
        return List.of();
    }


}
