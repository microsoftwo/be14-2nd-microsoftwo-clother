package com.microsoftwo.clother.post.query.controller;

import com.microsoftwo.clother.post.query.dto.PostAndHairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostDTO;
import com.microsoftwo.clother.post.query.dto.TestPostDTO;
import com.microsoftwo.clother.post.query.service.PostService;
import com.microsoftwo.clother.post.query.vo.ResponsePostVO;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@Slf4j
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/test")
    public void test() {
        TestPostDTO testPostDTO = postService.test();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ResponsePostVO> getPostById(@PathVariable int postId) {
        PostAndHairTagDTO postAndHairTagDTO = postService.getPostById(postId);

        if (postAndHairTagDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }


        /* todo. 회원 정보 요청 */

        /* todo. 북마크 여부 요청 */

        /* todo. 좋아요 여부 요청 */

        /* todo. 댓글 정보 요청 */

        /* todo. 상품, 카테고리 정보 요청 */

        ResponsePostVO returnValue = new ResponsePostVO();

        // DTO VO로 매핑
        returnValue.setId(postAndHairTagDTO.getId());
        returnValue.setUserId(postAndHairTagDTO.getUserId());
        returnValue.setContent(postAndHairTagDTO.getContent());
        returnValue.setCreatedAt(postAndHairTagDTO.getCreatedAt());
        returnValue.setLikeCount(postAndHairTagDTO.getLikeCount());
        returnValue.setCommentCount(postAndHairTagDTO.getCommentCount());
        returnValue.setImageUrls(postAndHairTagDTO.getImageUrls());
        returnValue.setLookTags(postAndHairTagDTO.getLookTags());
        returnValue.setHairTagId(postAndHairTagDTO.getHairTagId());
        returnValue.setHairTagLink(postAndHairTagDTO.getHairTagLink());
        returnValue.setHairTagName(postAndHairTagDTO.getHairTagName());
        returnValue.setHairTagCategoryId(postAndHairTagDTO.getHairTagCategoryId());
        returnValue.setHairTagPositionX(postAndHairTagDTO.getHairTagPositionX());
        returnValue.setHairTagPositionY(postAndHairTagDTO.getHairTagPositionY());



        /* todo. 추가 요청된 데이터 ResponsePostVO에 매핑 */




        return ResponseEntity.ok(returnValue);
    }
}
