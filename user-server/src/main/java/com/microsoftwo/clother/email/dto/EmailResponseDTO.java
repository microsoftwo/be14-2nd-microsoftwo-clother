package com.microsoftwo.clother.email.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmailResponseDTO {
    private String message;
    private int authNumber;
}
