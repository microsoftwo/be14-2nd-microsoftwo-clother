package com.microsoftwo.clother.product.command.application.controller;

import com.microsoftwo.clother.product.command.application.dto.ProductRegistDTO;
import com.microsoftwo.clother.product.command.domain.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class ProductRegistController {

    private final ProductService productService;

    public ProductRegistController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/users/{userId}/registproduct")
    public String registProduct(
            @RequestBody ProductRegistDTO newProduct,
            @PathVariable("userId") int userId) {
        newProduct.setUserId(userId); // userId 는 로그인을 가정하고 Id 값만 받아옴
        productService.registProduct(newProduct);
        return "상품 등록 신청이 완료되었습니다";
    }


}
