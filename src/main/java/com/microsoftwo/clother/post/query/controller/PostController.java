package com.microsoftwo.clother.post.query.controller;

import com.microsoftwo.clother.post.query.dto.PostDTO;
import com.microsoftwo.clother.post.query.dto.TestPostDTO;
import com.microsoftwo.clother.post.query.service.PostService;
import com.microsoftwo.clother.post.query.vo.ResponsePostVO;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        PostDTO postDTO = postService.getPostById(postId);

        /* todo. 회원 정보 요청 */

        /* todo. 북마크 여부 요청 */

        /* todo. 좋아요 여부 요청 */

        /* todo. 댓글 정보 요청 */

        /* todo. 상품, 카테고리 정보 요청 */

        /* todo. 추가 요청된 데이터 ResponsePostVO에 매핑 */
        ResponsePostVO returnValue = DTOsToResponsePostVO(postDTO);

        return ResponseEntity.ok(returnValue);
    }

    private ResponsePostVO DTOsToResponsePostVO(PostDTO postDTO) {
        ResponsePostVO responsePostVO = new ResponsePostVO();

        // imageUrls는 null일 수 없음
        List<String> imageUrls = Arrays.stream(postDTO.getImageUrls().split(",")).toList();

        // lookTags는 null 가능
        List<String> lookTags = null;
        if (postDTO.getLookTags() != null) {
            lookTags = Arrays.stream(postDTO.getLookTags().split(",")).toList();
        }

        // hairTags는 null 가능
        List<String> hairTags = null;
        if (postDTO.getHairTags() != null) {
            hairTags = Arrays.stream(postDTO.getHairTags().split(",")).toList();
        }

        responsePostVO.setId(postDTO.getId());
        responsePostVO.setUserId(postDTO.getUserId());
        responsePostVO.setCreatedAt(postDTO.getCreatedAt());
        responsePostVO.setContent(postDTO.getContent());
        responsePostVO.setLikeCount(postDTO.getLikeCount());
        responsePostVO.setCommentCount(postDTO.getCommentCount());
        responsePostVO.setImageUrls(imageUrls);
        responsePostVO.setLookTags(lookTags);
        responsePostVO.setHairTags(hairTags);

        return responsePostVO;
    }
}
