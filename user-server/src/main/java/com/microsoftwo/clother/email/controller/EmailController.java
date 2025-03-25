package com.microsoftwo.clother.email.controller;

import com.microsoftwo.clother.email.dto.EmailCheckDTO;
import com.microsoftwo.clother.email.exception.CustomException;
import com.microsoftwo.clother.email.service.EmailServiceImpl;
import com.microsoftwo.clother.email.vo.EmailRequestVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mails")
public class EmailController {
    private final EmailServiceImpl mailService;

    // 인증 코드 전송
    @PostMapping
    public String mailSend(@RequestBody @Valid EmailRequestVO emailRequestVO) {
        return mailService.joinEmail(emailRequestVO.getEmail());
    }

    /* memo : 인증 코드가 일치하는지 확인 */
    @PostMapping("/verification")
    public ResponseEntity<String> AuthCheck(@RequestBody @Valid EmailCheckDTO emailCheckDto) {
        // 이메일이 이미 가입되어 있는지 확인
        if (mailService.isEmailRegistered(emailCheckDto.getEmail())) {
            return ResponseEntity.badRequest().body("이미 가입된 이메일입니다.");
        }

        // 인증 코드 검증
        boolean isChecked = mailService.CheckAuthNum(emailCheckDto.getEmail(), emailCheckDto.getAuthNum());
        if (isChecked) {
            return ResponseEntity.ok("인증 코드가 일치합니다.");
        } else {
            throw new CustomException("인증 코드가 일치하지 않습니다.");
        }
    }
}
