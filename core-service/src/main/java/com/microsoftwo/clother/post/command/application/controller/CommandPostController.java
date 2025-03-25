package com.microsoftwo.clother.post.command.application.controller;

import com.microsoftwo.clother.post.command.application.service.CommandPostService;
import com.microsoftwo.clother.post.command.domain.vo.RequestRegistPostVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@Slf4j
public class CommandPostController {

    private final CommandPostService commandPostService;

    @Autowired
    public CommandPostController(CommandPostService commandPostService) {
        this.commandPostService = commandPostService;
    }

    @PostMapping("")
    public ResponseEntity<Void> registPost(@RequestBody RequestRegistPostVO newPost) {
        commandPostService.registPost(newPost);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
