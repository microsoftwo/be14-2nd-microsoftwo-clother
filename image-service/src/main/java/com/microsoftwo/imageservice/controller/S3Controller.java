package com.microsoftwo.imageservice.controller;

import com.microsoftwo.imageservice.service.S3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
@Slf4j
public class S3Controller {

    private final S3Service s3Service;

    @Autowired
    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @GetMapping("/test")
    public String test() {
        return "I'm alive";
    }

    @GetMapping("/url")
    public ResponseEntity<String> getPresignedUrl(@RequestParam String fileName) {
        String presignedUrl = s3Service.generatePresignedUrl(fileName);
        return ResponseEntity.ok(presignedUrl);
    }
}
