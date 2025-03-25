package com.microsoftwo.clother.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreServiceController {
    private final UserServiceClient userServiceClient;

    @Autowired
    public CoreServiceController(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader,
            @RequestBody UserDTO user
    ) {
        // 토큰 추출
        String token = authorizationHeader.substring(7);

        // user-server의 createUser 메서드 호출
        UserDTO createdUser = userServiceClient.createUser(user);

        return ResponseEntity.ok(createdUser);
    }
}
