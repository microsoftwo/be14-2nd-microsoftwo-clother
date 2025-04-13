package com.microsoftwo.imageservice.service;

import java.util.List;

public interface S3Service {
    String generatePresignedUrl(String fileName);

    void deleteObjects(List<String> fileNames);
}
