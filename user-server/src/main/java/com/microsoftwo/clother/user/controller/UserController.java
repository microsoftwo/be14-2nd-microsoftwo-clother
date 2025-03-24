package com.microsoftwo.clother.user.controller;

import com.microsoftwo.clother.security.dto.TokenDTO;
import com.microsoftwo.clother.security.service.AuthService;
import com.microsoftwo.clother.security.vo.LoginRequestVO;
import com.microsoftwo.clother.user.service.UserService;
import com.microsoftwo.clother.user.vo.SignupRequestVO;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    // 기능 : 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestVO signupRequestVO,
                                          BindingResult bindingResult) {
        // 유효성 검사 실패 시 처리
        if (bindingResult.hasErrors()) {
            log.error("회원가입 요청 유효성 검사 실패: {}", signupRequestVO.getEmail());

            // 에러 메시지를 담을 Map 생성
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // 로그 출력
            errors.forEach((field, message) -> log.error("유효성 오류 - {}: {}", field, message));

            return ResponseEntity.badRequest().body(errors);
        }

        // 회원가입 진행
        String result = userService.registerUser(signupRequestVO);
        return ResponseEntity.ok(result);
    }

    // 기능 : 로그인
    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginRequestVO loginRequestVO) {
        return ResponseEntity.ok(authService.login(loginRequestVO));
    }
}
