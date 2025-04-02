package com.microsoftwo.imageservice.service;

public interface S3Service {
    String generatePresignedUrl(String fileName);
}
