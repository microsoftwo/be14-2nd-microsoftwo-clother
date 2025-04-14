package com.microsoftwo.clother.likes.command.application.controller;

import com.microsoftwo.clother.common.JwtUtil;
import com.microsoftwo.clother.likes.command.application.service.LikeService;
import com.microsoftwo.clother.likes.command.domain.vo.RequestLikeVO;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeRegistController {

    private final LikeService likeService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Void> createLike(@RequestHeader(value = "Authorization") String authorizationHeader,
                                           @RequestBody RequestLikeVO requestLikeVO) {

        String token = authorizationHeader.replace("Bearer", "").trim();
        Claims claims = jwtUtil.parseJwt(token);
        int userId = ((Number) claims.get("userId")).intValue();

        likeService.createLike(requestLikeVO, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable int id,
                                           @RequestHeader(value = "Authorization") String authorizationHeader) {

        String token = authorizationHeader.replace("Bearer", "").trim();
        Claims claims = jwtUtil.parseJwt(token);
        int userId = ((Number) claims.get("userId")).intValue();

        likeService.deleteLike(id, userId);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
