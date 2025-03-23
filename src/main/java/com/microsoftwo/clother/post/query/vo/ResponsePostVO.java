package com.microsoftwo.clother.post.query.vo;

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
public class ResponsePostVO {
    // post domain에서 가져온 값
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
    private BigDecimal hairTagPositionX;
    private BigDecimal hairTagPositionY;

    /* todo. 회원 정보 요청해서 추가될 값 */

    /* todo. 북마크 여부 요청해서 추가될 값 */

    /* todo. 좋아요 여부 요청해서 추가될 값 */

    /* todo. 댓글 정보 요청해서 추가될 값 */
    
    /* todo. 상품, 카테고리 정보 요청해서 추가될 값 */

}
