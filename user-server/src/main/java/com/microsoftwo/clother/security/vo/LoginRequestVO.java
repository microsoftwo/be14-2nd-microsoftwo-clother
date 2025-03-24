package com.microsoftwo.clother.security.vo;

import com.microsoftwo.clother.user.aggregate.Role;
import com.microsoftwo.clother.user.aggregate.UserEntity;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class LoginRequestVO {
    private String email;
    private String password;

    public UserEntity toUserEntity(PasswordEncoder passwordEncoder) {
        return UserEntity.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
