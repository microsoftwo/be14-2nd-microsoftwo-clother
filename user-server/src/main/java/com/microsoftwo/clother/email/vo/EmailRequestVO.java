package com.microsoftwo.clother.email.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmailRequestVO {
    @Email(message = "올바른 형식의 이메일 주소를 입력해주세요")
    // @ 기호 포함 / @ 기준으로 로컬호스트, 도메인파트 나뉨 / 도메인파트는 . 후에 2개 이상의 알파벳 필요
    @NotEmpty(message = "이메일을 입력해 주세요")
    private String email;
}
