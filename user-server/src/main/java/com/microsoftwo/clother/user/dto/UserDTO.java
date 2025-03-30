package com.microsoftwo.clother.user.dto;

import lombok.Getter;

@Getter
public class UserDTO {
    private String email;
    private String encryptedPwd;
    private String nickname;
    private String gender;
    private int height;
    private int weight;
    private String role;
}
