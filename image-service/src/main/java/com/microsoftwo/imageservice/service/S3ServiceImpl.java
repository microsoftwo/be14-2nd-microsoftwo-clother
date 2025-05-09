package com.microsoftwo.imageservice.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsRequest.KeyVersion;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class S3ServiceImpl implements S3Service {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    @Autowired
    public S3ServiceImpl(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    @Override
    public String generatePresignedUrl(String fileName) {
        // Presigned URL 만료 시간 (10분)
        Date expiration = new Date();
        expiration.setTime(expiration.getTime() + (1000 * 60 * 10));

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String uniqueFileName = (timeStamp + UUID.randomUUID()).replaceAll("[-_]", "");

        // Presigned URL 생성 요청
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, uniqueFileName)
                        .withMethod(HttpMethod.PUT)
                        .withExpiration(expiration);

        URL presignedUrl = amazonS3Client.generatePresignedUrl(generatePresignedUrlRequest);
        return presignedUrl.toString();
    }

    @Override
    public void deleteObjects(List<String> fileNames) {
        if (fileNames == null || fileNames.isEmpty()) return;

        List<KeyVersion> keys = fileNames.stream()
                .map(this::toKeyVersion)
                .toList();

        DeleteObjectsRequest deleteRequest = new DeleteObjectsRequest(bucketName)
                .withKeys(keys)
                .withQuiet(true); // 실패 목록만 반환

        amazonS3Client.deleteObjects(deleteRequest);
    }

    private KeyVersion toKeyVersion(String fileNameOrUrl) {
        String key = fileNameOrUrl.contains("/")
                ? extractKeyFromUrl(fileNameOrUrl)
                : fileNameOrUrl;
        return new KeyVersion(key);
    }

    private String extractKeyFromUrl(String url) {
        String[] parts = url.split("/");
        return parts[parts.length - 1];
    }
}
