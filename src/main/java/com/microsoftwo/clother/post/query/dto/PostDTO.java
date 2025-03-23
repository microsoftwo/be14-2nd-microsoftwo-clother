package com.microsoftwo.clother.post.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostDTO {
    private int id;
    private int userId;
    private String createdAt;
    private String content;
    private int likeCount;
    private int commentCount;
    private String imageUrls;
    private String lookTags;
    private String hairTagIds;
}
