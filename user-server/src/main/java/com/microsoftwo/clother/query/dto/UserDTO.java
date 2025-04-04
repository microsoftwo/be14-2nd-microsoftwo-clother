package com.microsoftwo.clother.query.dto;

import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDTO {
    private int id;        // 회원 id
    private String email;
    private String password;
    private String nickname;
    private String gender;
    private int height;
    private int weight;
    private String role;
    private String bio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isSuspended;
    private Boolean isDeleted;
    private String imageUrl;

}
