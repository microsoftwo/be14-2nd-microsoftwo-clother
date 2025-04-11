package com.microsoftwo.clother.email.service;

import com.microsoftwo.clother.email.dto.EmailResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    EmailResponseDTO joinEmail(String email);

    boolean CheckAuthNum(String email, String authNum);

    boolean isEmailRegistered(String email);
}
