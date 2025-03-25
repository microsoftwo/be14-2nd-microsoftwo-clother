package com.microsoftwo.clother.product.command.application.controller;

import com.microsoftwo.clother.product.command.application.dto.ProductRegistDTO;
import com.microsoftwo.clother.product.command.domain.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class ProductRegistController {

    private final ProductService productService;

    public ProductRegistController(ProductService productService) {
        this.productService = productService;
    }

    /* 설명. 상품 등록하기 (insert) */
    @PostMapping("/users/{userId}/apply-product")
    public String applyForProductRegistration(
            @PathVariable("userId") int userId,
            @RequestBody ProductRegistDTO newProduct) {
        newProduct.setUserId(userId); // userId 는 로그인을 가정하고 Id 값만 받아옴
        productService.applyForProductRegistration(newProduct);
        return "상품 등록 신청이 완료되었습니다";
    }

    /* 설명. 상품 수정하기 (update) */
    @PutMapping("/users/{userId}/registproduct/{productId}")
    public String modifyProduct(
            @PathVariable int productId,
            @PathVariable int userId,
            @RequestBody ProductRegistDTO modifiedProduct) {
        modifiedProduct.setUserId(userId);
        productService.updateProduct(productId, modifiedProduct);
        return "상품 수정이 완료되었습니다";
    }

}
