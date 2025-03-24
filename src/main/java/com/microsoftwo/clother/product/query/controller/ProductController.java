package com.microsoftwo.clother.product.query.controller;

import com.microsoftwo.clother.product.query.dto.CategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductCategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductDetailDTO;
import com.microsoftwo.clother.product.query.dto.ProductRegistHistoryDTO;
import com.microsoftwo.clother.product.query.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 카테고리 목록 조회
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categories = productService.getCategories();
        return ResponseEntity.ok(categories);
    }

    // 카테고리 별 전체 상품 목록 조회
    @GetMapping("/categories/products")
    public ResponseEntity<List<ProductCategoryDTO>> getProductsByCategory(
            @RequestParam("categoryName") List<String> categoryNames) {
        List<ProductCategoryDTO> products = productService.getProductListByCategory(categoryNames);
        return ResponseEntity.ok(products);
    }

    // 사용자가 등록 신청한 상품 목록 조회
    @GetMapping("/users/{userId}/mypage")
    public ResponseEntity<List<ProductRegistHistoryDTO>> getProductRegistHistoryByUserId(
            @PathVariable("userId") int userId) {
        List<ProductRegistHistoryDTO> productHistories = productService.getProductRegistHistoryByUserId(userId);
        return ResponseEntity.ok(productHistories);
    }

    // 상품 상세 정보 조회
    @GetMapping("/categories/post/{productId}/productdetail")
    public ResponseEntity<ProductDetailDTO> getProductDetailByProductId(
            @PathVariable("productId") int productId) {
        ProductDetailDTO productDetail = productService.getProductDetailByProductId(productId);
        return ResponseEntity.ok(productDetail);
    }

}
