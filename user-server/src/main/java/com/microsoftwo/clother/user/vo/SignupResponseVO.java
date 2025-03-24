package com.microsoftwo.clother.user.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SignupResponseVO {
    private String email;
    private String name;
    private String userId;
}
