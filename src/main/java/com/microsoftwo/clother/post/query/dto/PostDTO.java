package com.microsoftwo.clother.post.query.dto;

import java.math.BigDecimal;
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
    private String content;
    private String createdAt;
    private int likeCount;
    private int commentCount;
    private String imageUrls;
    private String lookTags;
    private Integer hairTagId;
    private String hairTagLink;
    private BigDecimal hairTagPositionX;
    private BigDecimal hairTagPositionY;
}
