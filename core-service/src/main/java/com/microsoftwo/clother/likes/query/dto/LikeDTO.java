package com.microsoftwo.clother.likes.query.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LikeDTO {
    private int id; // 좋아요 대상 ID
    private String type; // post, comment, board
    private String content; // 내용
    private LocalDateTime createdAt; // 생성 날짜

    public LikeDTO(int id, String type, String content, LocalDateTime createdAt) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.createdAt = createdAt;
    }
}
