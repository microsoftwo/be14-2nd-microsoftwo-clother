package com.microsoftwo.clother.user.controller;

import com.microsoftwo.clother.email.exception.CustomException;
import com.microsoftwo.clother.security.dto.TokenDTO;
import com.microsoftwo.clother.security.service.AuthService;
import com.microsoftwo.clother.security.vo.LoginRequestVO;
import com.microsoftwo.clother.user.service.UserService;
import com.microsoftwo.clother.user.vo.SignupRequestVO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<String> registerUser(@RequestBody @Valid SignupRequestVO signupRequestVO) {
        // BindingResult 제거: GlobalExceptionHandler가 유효성 검사 오류를 처리

        // 닉네임 중복 검사
        if (userService.isNicknameExists(signupRequestVO.getNickname())) {
            throw new CustomException("이미 존재하는 닉네임입니다.");
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

    // 테스트
    // JWT를 포함한 요청에서 사용자 정보 조회
    @GetMapping("/me")
    public ResponseEntity<String> getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body("토큰이 유효하지 않습니다.");
        }

        return ResponseEntity.ok("로그인한 유저의 이메일 : " + userDetails.getUsername());
    }
}
