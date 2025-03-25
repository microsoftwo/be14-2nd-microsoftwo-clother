package com.microsoftwo.clother.post.query.controller;

import com.microsoftwo.clother.post.query.dto.PostAndHairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostForFeedDTO;
import com.microsoftwo.clother.post.query.service.QueryPostService;
import com.microsoftwo.clother.post.query.vo.ResponsePostVO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@Slf4j
public class QueryPostController {

    private final QueryPostService queryPostService;

    @Autowired
    public QueryPostController(QueryPostService queryPostService) {
        this.queryPostService = queryPostService;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ResponsePostVO> getPostById(@PathVariable int postId) {
        PostAndHairTagDTO postAndHairTagDTO = queryPostService.getPostById(postId);

        if (postAndHairTagDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

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

    @GetMapping("/feed")
    public ResponseEntity<List<PostForFeedDTO>> getPostFeedOrderByDate(
            @RequestParam(required = false) Integer lastPostId) {

        List<PostForFeedDTO> posts = queryPostService.getPostFeedOrderByDate(lastPostId);
        return ResponseEntity.ok(posts);
    }
}
