package com.microsoftwo.clother.security.vo;

import lombok.Data;

@Data
public class TokenRequestVO {
    private String accessToken;
    private String refreshToken;
}
