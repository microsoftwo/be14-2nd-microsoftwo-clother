package com.microsoftwo.clother.post.query.controller;

import com.microsoftwo.clother.common.JwtUtil;
import com.microsoftwo.clother.post.query.dto.PostAndHairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostForFeedDTO;
import com.microsoftwo.clother.post.query.dto.ResponsePostDetailDTO;
import com.microsoftwo.clother.post.query.service.QueryPostService;
import com.microsoftwo.clother.post.query.vo.ResponsePostVO;
import io.jsonwebtoken.Claims;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@Slf4j
public class QueryPostController {

    private final QueryPostService queryPostService;
    private final JwtUtil jwtUtil;

    @Autowired
    public QueryPostController(QueryPostService queryPostService, JwtUtil jwtUtil) {
        this.queryPostService = queryPostService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ResponsePostDetailDTO> getPostById(@PathVariable int postId) {
        ResponsePostDetailDTO responsePostDetailDTO = queryPostService.getPostById(postId);

        return ResponseEntity.ok(responsePostDetailDTO);
    }

    @GetMapping("/feed")
    public ResponseEntity<List<PostForFeedDTO>> getPostFeedOrderByDate(
            @RequestParam(required = false) Integer lastPostId) {

        List<PostForFeedDTO> posts = queryPostService.getPostFeedOrderByDate(lastPostId);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/test")
    public void headerTest(@RequestHeader(value = "Authorization") String authorizationHeader) {
        // "Bearer " 부분 제거
        String token = authorizationHeader.replace("Bearer", "").trim();
        Claims claims = jwtUtil.parseJwt(token);
        log.info(claims.toString());
        log.info(authorizationHeader);
    }
}
