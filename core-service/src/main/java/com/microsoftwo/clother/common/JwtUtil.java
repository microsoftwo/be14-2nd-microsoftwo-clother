package com.microsoftwo.clother.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtUtil {

    @Value("${spring.jwt.secret}")
    private String secretKey;

    @PostConstruct
    public void init() {
        log.info("secretKey: {}", secretKey);
    }

    public Claims parseJwt(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

//    public String getSubject(String token) {
//        return parseJwt(token).getSubject();
//    }
//
//    public String getAuth(String token) {
//        return parseJwt(token).get("auth", String.class);
//    }
}