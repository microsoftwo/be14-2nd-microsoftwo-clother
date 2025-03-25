package com.microsoftwo.clother.user.service;

import com.microsoftwo.clother.email.dto.EmailCheckDTO;
import com.microsoftwo.clother.security.vo.LoginResponseVO;
import com.microsoftwo.clother.user.vo.SignupRequestVO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    String registerUser(@Valid SignupRequestVO signupRequestVO);

    LoginResponseVO findMemberInfoById(Long userId);

    LoginResponseVO findMemberInfoByEmail(String email);

    boolean isNicknameExists(String nickname);

    boolean isEmailRegistered(String email);

    ResponseEntity<String> verifyEmailAuthentication(@Valid EmailCheckDTO emailCheckDto);
}
