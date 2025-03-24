package com.microsoftwo.clother.security.vo;

import com.microsoftwo.clother.user.aggregate.UserEntity;
import lombok.Data;

@Data
public class LoginResponseVO {
    private String email;

    public static LoginResponseVO of(UserEntity userEntity) {
        return new LoginResponseVO();
    }
}
