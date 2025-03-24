package com.microsoftwo.clother.product.query.controller;

import com.microsoftwo.clother.product.query.dto.CategoryDTO;
import com.microsoftwo.clother.product.query.dto.ProductRegistHistoryDTO;
import com.microsoftwo.clother.product.query.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/main")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categories = productService.getCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/users/{userId}/mypage")
    public ResponseEntity getProductRegistHistoryByUserId(@PathVariable("userId") int userId) {
        System.out.println("요청 받은 userId: " + userId);
        List<ProductRegistHistoryDTO> productHistroies = productService.getProductRegistHistoryByUserId(userId);
        return ResponseEntity.ok(productHistroies);
    }
}
