package com.microsoftwo.clother.product.command.application.controller;

import com.microsoftwo.clother.product.command.application.dto.ProductRegistDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class ProductController {

    @PostMapping("/users/{userId}/mypage/registproduct")
    public ResponseEntity<?> registProduct(
            @RequestBody ProductRegistDTO newProduct,
            @PathVariable("userId") String userId) {
        log.info(newProduct.toString());
        return ResponseEntity.ok(newProduct);
    }


}
