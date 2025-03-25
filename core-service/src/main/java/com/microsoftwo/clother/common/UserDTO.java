package com.microsoftwo.clother.common;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String token;
    private int userId;
    private String nickname;
    private String imageUrl;

    public void setToken(String token) {
        this.token = token;
    }
}
