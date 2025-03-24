package com.microsoftwo.clother.email.controller;

import com.microsoftwo.clother.email.dto.EmailCheckDTO;
import com.microsoftwo.clother.email.service.EmailServiceImpl;
import com.microsoftwo.clother.email.vo.EmailRequestVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class EmailController {
    private final EmailServiceImpl mailService;

    /* memo : 인증 코드 전송 */
    @PostMapping("/Send")
    public String mailSend(@RequestBody @Valid EmailRequestVO emailRequestVO) {
        return mailService.joinEmail(emailRequestVO.getEmail());
    }

    /* memo : 인증 코드가 일치하는지 확인 */
    @PostMapping("/authCheck")
    public String AuthCheck(@RequestBody @Valid EmailCheckDTO emailCheckDto) {
        boolean Checked = mailService.CheckAuthNum(emailCheckDto.getEmail(), emailCheckDto.getAuthNum());
        if (Checked) {
            return "인증 코드가 일치합니다.";
        } else {
            throw new NullPointerException("인증 코드가 일치하지 않습니다.");
        }
    }
}
