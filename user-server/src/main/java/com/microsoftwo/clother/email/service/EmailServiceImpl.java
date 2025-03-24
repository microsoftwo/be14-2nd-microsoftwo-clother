package com.microsoftwo.clother.email.service;

import com.microsoftwo.clother.email.config.RedisUtil;
import com.microsoftwo.clother.user.service.UserService;
import java.util.Random;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final RedisUtil redisUtil;
    private final UserService userService;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender, RedisUtil redisUtil, UserService userService) {
        this.mailSender = mailSender;
        this.redisUtil = redisUtil;
        this.userService = userService;
    }

    private int authNumber;

    // 임의의 6자리 양수를 반환 (이메일 인증 코드)
    public void makeRandomNumber() {
        Random r = new Random();
        String randomNumber = "";
        for (int i = 0; i < 6; i++) {
            randomNumber += Integer.toString(r.nextInt(10));
        }

        authNumber = Integer.parseInt(randomNumber);
    }

    @Override
    public String joinEmail(String email) {
        makeRandomNumber();
        String setFrom = "\"Clother Admin\" <yushiii002@gmail.com>";
        String toMail = email;
        String title = "회원 가입 인증 이메일 입니다.";
        String content =
                "<h1>Clother</h1>" +
                        "<br><br>" +
                        "고객님의 인증번호는 다음과 같습니다." +
                        "<h3>" + authNumber + "</h3>" +
                        "<br>";
        //이메일 내용
        mailSend(setFrom, toMail, title, content);
        return Integer.toString(authNumber);
    }

    @Override
    public boolean CheckAuthNum(String email, String authNum) {
        String storedAuthNum = redisUtil.getData(email);                // email을 키로 조회
        return storedAuthNum != null && storedAuthNum.equals(authNum);
    }

    @Override
    public boolean isEmailRegistered(String email) {
        return userService.isEmailRegistered(email);
    }

    // 이메일 전송
    public void mailSend(String setFrom, String toMail, String title, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        // 인증번호를 email을 키로 저장
        redisUtil.setDataExpire(toMail, Integer.toString(authNumber), 5);
    }
}
