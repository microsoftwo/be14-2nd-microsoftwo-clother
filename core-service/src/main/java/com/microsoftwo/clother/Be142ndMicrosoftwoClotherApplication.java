package com.microsoftwo.clother;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.microsoftwo.clother")
@EnableDiscoveryClient
public class Be142ndMicrosoftwoClotherApplication {

    public static void main(String[] args) {
        SpringApplication.run(Be142ndMicrosoftwoClotherApplication.class, args);
    }

}
