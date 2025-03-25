package com.microsoftwo.clother.likes.command.application.controller;

import com.microsoftwo.clother.likes.command.application.dto.LikeDTO;
import com.microsoftwo.clother.likes.command.application.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeRegistController {

    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<LikeDTO> createLike(@RequestBody LikeDTO likeDTO) {
        System.out.println(likeDTO.toString());
        return ResponseEntity.ok(likeService.createLike(likeDTO));
    }

}
