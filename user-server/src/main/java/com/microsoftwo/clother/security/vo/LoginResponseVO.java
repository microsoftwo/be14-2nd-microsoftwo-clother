package com.microsoftwo.clother.security.vo;

import com.microsoftwo.clother.user.aggregate.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginResponseVO {
    private String email;

    public static LoginResponseVO of(UserEntity userEntity) {
        return new LoginResponseVO();
    }
}
