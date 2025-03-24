package com.microsoftwo.clother.post.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PostDTO {
    private int id;
    private int userId;
    private String content;
    private String createdAt;
    private int likeCount;
    private int commentCount;
    private String imageUrls;
    private String lookTags;
}
