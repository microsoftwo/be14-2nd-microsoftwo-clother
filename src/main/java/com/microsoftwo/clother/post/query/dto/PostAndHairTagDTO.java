package com.microsoftwo.clother.post.query.dto;

import java.math.BigDecimal;
import java.util.List;
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
public class PostAndHairTagDTO {
    private int id;
    private int userId;
    private String content;
    private String createdAt;
    private int likeCount;
    private int commentCount;
    private List<String> imageUrls;
    private List<String> lookTags;
    private Integer hairTagId;
    private String hairTagLink;
    private String hairTagName;
    private Integer hairTagCategoryId;
    private BigDecimal hairTagPositionX;
    private BigDecimal hairTagPositionY;
}
