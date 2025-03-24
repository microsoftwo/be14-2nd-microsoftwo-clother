package com.microsoftwo.clother.post.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PostForFeedDTO {
    private int id;
    private int likeCount;
    private int commentCount;
    private String thumbnailUrl;
}
