package com.microsoftwo.clother.security.service;

import com.microsoftwo.clother.security.aggregate.RefreshToken;
import com.microsoftwo.clother.security.dto.TokenDTO;
import com.microsoftwo.clother.security.jwt.TokenProvider;
import com.microsoftwo.clother.security.repository.RefreshTokenRepository;
import com.microsoftwo.clother.security.vo.LoginRequestVO;
import com.microsoftwo.clother.security.vo.LoginResponseVO;
import com.microsoftwo.clother.user.aggregate.UserEntity;
import com.microsoftwo.clother.user.repository.UserRepository;
import com.microsoftwo.clother.user.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    //    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserService userService;


    public AuthService(AuthenticationManager authenticationManager, UserRepository userRepository,
                       PasswordEncoder passwordEncoder, TokenProvider tokenProvider,
                       RefreshTokenRepository refreshTokenRepository, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
        this.refreshTokenRepository = refreshTokenRepository;
        this.userService = userService;
    }

    @Transactional
    public LoginResponseVO signup(LoginRequestVO loginRequestVO) {
        if (userRepository.existsByEmail(loginRequestVO.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }

        UserEntity user = loginRequestVO.toUserEntity(passwordEncoder);
        return LoginResponseVO.of(userRepository.save(user));
    }

    @Transactional
    public TokenDTO login(LoginRequestVO loginRequestVO) {
        // Login ID/PW 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = loginRequestVO.toAuthenticationToken();

        // 검증 (사용자 비밀번호 체크)
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // 로그인한 유저의 정보 가져오기
        UserEntity userEntity = userRepository.findByEmail(loginRequestVO.getEmail())
                .orElseThrow(() -> new RuntimeException("해당 유저를 찾을 수 없습니다."));

        // 인증 정보를 기반으로 JWT 토큰 생성
        TokenDTO tokenDTO = tokenProvider.generateTokenDTO(authentication, userEntity.getId());

        // RefreshToken 저장
        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDTO.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);

        // 토큰 발급
        return TokenDTO.builder()
                .grantType(tokenDTO.getGrantType())
                .accessToken(tokenDTO.getAccessToken())
                .refreshToken(tokenDTO.getRefreshToken())
                .accessTokenExpiresIn(tokenDTO.getAccessTokenExpiresIn())
                .userId(userEntity.getId())
                .build();
    }
}
